function recursion_by_level($id, $db, $level = 0){
    $user = array();
    $user = $db->runQuerySelect("SELECT id, username FROM users where id_parent = '{$id}' order by username ASC ");

    if($level == 0) {
        return $user;
    } else {
        $user2 = array();
        $level--;  //////to call all childs at same level
        foreach ($user as $u) {
            $user_h = recursion_by_level($u['id'], $db, $level) ;
            //////add all children of this child
            if(count($user_h)>0) {
                $user2 = array_merge($user_h, $user2);
            }
        }
    }
    return $user2;
}

