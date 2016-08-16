<?php

class CRUD {
    
    var $db = null ;
    var $key = null ;
    var $table = null ;
    var $delete_condition = " Status='4' " ;
    var $itemsPerPage = 5 ;
    
    function __construct($db){
        $this->db = $db;
    }
    
    function get($parameters=null,&$options=array()) {
        
        if( is_numeric($parameters) ) {

            $where_clause = $parameters ? " {$this->key}={$parameters} " : '1' ;
            
        } else if( is_array($parameters) and count($parameters) ) {
        
            foreach($parameters as $k=>$v){
                //if($k==$this->key) continue;
                $arreglo[]="{$k} LIKE '{$v}'";
            }
           
            $where_clause = implode(' AND ',$arreglo);

        } else {

            $where_clause = '1' ;

        }


        $limitStart = isset($options['page'])
                ? ($options['page']-1) * $this->itemsPerPage
                : 0 ;


        if($this->delete_condition) $where_clause .= " AND NOT {$this->delete_condition} " ;
        $limit_clause = $options['page']>0 ? " LIMIT $limitStart, {$this->itemsPerPage} " : '' ;

        $query = "
            SELECT * FROM {$this->table}
            WHERE $where_clause
            ORDER BY {$this->key} DESC
            $limit_clause
            " ;

        $result = $this->db->runQuerySelect($query);


        $count_query = " 
            SELECT count({$this->key}) as Total
            FROM {$this->table}
            WHERE $where_clause
            " ;

        //die($query);
        $count_result = $this->db->runQuerySelect($count_query);
        $options['pages'] = ceil($count_result[0]['Total']/$this->itemsPerPage) ;
       
        //die( var_dump($count_result) );

        return  is_numeric($parameters) ? $result[0] : $result ;
    }

    
    function add($record) {
        $fields = implode(',',array_keys($record));
        $values = implode("','",$record);
        $insert = "INSERT INTO {$this->table} ($fields) VALUES ('$values')" ;
        //echo $insert;
        
        $result = $this->db->insert($insert);
        return $result;
    }

    
    function set($record) {
        foreach($record as $k=>$v){
            if($k==$this->key) continue;
            $arreglo[]="{$k}='{$v}'";
        }
        $fields = implode(', ',$arreglo);
        $update = "UPDATE {$this->table} SET {$fields}
                    WHERE {$this->key}='{$record[$this->key]}' ";

        $result = $this->db->getQueryResult($update);
    }    


    function delete($id) {
        $delete = "UPDATE {$this->table}
                    SET {$this->delete_condition} 
                    WHERE {$this->key}='{$id}' ";
        $result = $this->db->getQueryResult($delete);
    }


    function remove($id) {
        $delete = "DELETE FROM {$this->table} 
                    WHERE {$this->key}='{$id}' ";
        $result = $this->db->getQueryResult($delete);
    }
    
    
}

