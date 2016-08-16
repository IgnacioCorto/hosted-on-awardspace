<?php

function createDatePicker($name,$date='',$year_start=1968, $year_end=2030,$class='',$language='en') {
    $date_array = $date ? explode('-',$date) : explode('-',date("Y-m-d")) ;
    $yy = $date_array[0] ;
    $mm = $date_array[1] ;
    $dd = $date_array[2] ;
    
    $choice = array(
        'en'=>'-Choose-',
        'es'=>'-Elija-'
    );

    $months = array(
        'en' => array(
            '01'=>'January',    '02'=>'February', '03'=>'March',     '04'=>'April',
            '05'=>'May',        '06'=>'June',     '07'=>'July',      '08'=>'August',
            '09'=>'September',  '10'=>'October',  '11'=>'November',  '12'=>'December') ,
        'es' => array(
            '01'=>'Enero',      '02'=>'Febrero',  '03'=>'Marzo',     '04'=>'Abril',
            '05'=>'Mayo',       '06'=>'Junio',    '07'=>'Julio',     '08'=>'Agosto',
            '09'=>'Septiembre', '10'=>'Octubre',  '11'=>'Noviembre', '12'=>'Deciembre') ,
    );
    
    //$choice_label = $choice[$language];
    $choice_label = '- - -' ;

    $output = "\n<select name='{$name}_m' class='{$class}'>";
    $output .= "\n<option value=''>{$choice_label}</option>";
    foreach($months[$language] as $k=>$v){
        $selected = $mm==$k ? ' selected="selected" ' : '' ;
        $output .= "\n<option value='{$k}' {$selected}>{$v}</option>";
    }
    $output .= "\n</select>";

    $output .= "\n<select name='{$name}_d' class='{$class}'>";
    $output .= "\n<option value=''>{$choice_label}</option>";
    for($ii=1;$ii<=31;$ii++){
        $selected = $dd==$ii ? ' selected="selected" ' : '' ;
        $output .= "\n<option {$selected}>{$ii}</option>";
    }
    $output .= "\n</select>";

    $output .= "\n<select name='{$name}_y' class='{$class}'>";
    $output .= "\n<option value=''>{$choice_label}</option>";
    for($ii=$year_start;$ii<=$year_end;$ii++){
        $selected = $yy==$ii ? ' selected="selected" ' : '' ;
        $output .= "\n<option {$selected}>{$ii}</option>";
    }
    $output .= "\n</select>";
    
    return $output;
}




function createEvaluationPicker($name,$idpro=0,$idform) {
    $db = new DBConnection();
    $registros = $db->runQuerySelect("
        SELECT ID as 'ID'
              ,'Name as 'Name'
          FROM Evaluation
          WHERE ID={$idpro}
    ");

    $output = "\n<select name='{$name}' class='{$class}'>";
    $output .= "\n<option value=''>- - -</option>";
    foreach($registros as $form){
        $label_formulario = utf8_encode($form['Name']);
        $selected = $form['ID']==$idform ? ' selected="selected" ' : '' ;
        $output .= "\n<option value='{$form['ID']}' {$selected}>{$label_formulario}</option>";
    }    
    $output .= "\n</select>";

    return $output;
}


function createProjectPicker($name,$idp=0) {
    $db = new DBConnection();
    $registros = $db->runQuerySelect("
        SELECT  ID as 'ID'
              , Name as 'Name'
          FROM Project                                     
    ");

    $output = "\n<select name='{$name}' class='{$class}'>";
    $output .= "\n<option value=''>- - -</option>";
    foreach($registros as $form){
        $label_formulario = utf8_encode($form['Name']);
        $selected = $form['ID']==$idp ? ' selected="selected" ' : '' ;
        $output .= "\n<option value='{$form['ID']}' {$selected}>{$label_formulario}</option>";
    }    
    $output .= "\n</select>";

    return $output;
}


$createReportRow_bool = true ; 
function createReportRow($nivel, $estilo, $etiqueta, $monto, $valor,$diferencia=0){
    global $createReportRow_bool;
    $createReportRow_bool=!$createReportRow_bool;
    $zebra = $createReportRow_bool ? 'gvalternatingrowstyle'  : '' ;
    
    $etiqueta = str_repeat('&nbsp; ',$nivel*2).utf8_encode($etiqueta);
    $diferencia = $diferencia!=='' ? number_format($diferencia,2).'%' : '' ;
    $valor = number_format($valor,2).'%' ;
    
    switch($estilo){
        case 1:  $estilo_row='font-weight:bold;';  break;
        
    }
    
    echo  "<tr class='{$zebra}' style='{$estilo_row}'>
	<td>{$etiqueta}</td>
	<td align='center'>{$monto}</td>
	<td align='right'>{$valor}</td>
	<td align='right'>{$diferencia}</td>
        </tr>";
}


function ReportRecursion($arreglo, $nivel=1,$tabs=1) {
    foreach($arreglo as $dataName=>$dataValue) {
        createReportRow($tabs,1, $dataName, 3, 2, 1 );
	if($nivel>1) ReportRecursion($dataValue,$nivel-1,$tabs+1) ;
    }
}


### RECURSION EXAMPLE ###
ReportRecursion($report_data,5);


?>