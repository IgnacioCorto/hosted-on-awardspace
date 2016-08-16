<?php
/*
Plugin Name: adv-agenda
Plugin URI: http://mydomain.do/
Description: adv-agenda
Version: 0.1
Author: Ignacio Cortorreal
Author URI: http://mydomain.do/
License: GPL
*/

function adv_agenda_crear_widget() {
    include_once(plugin_dir_path(__FILE__) . '/includes/mpw.php');
    register_widget('adv_agenda');
}

function adv_agenda_css() {
   wp_register_style('adv_agenda-enlaces', plugins_url('adv-agenda/css/main.css'));
   wp_enqueue_style('adv_agenda-enlaces');
   wp_enqueue_script('adv_agenda-enlaces', plugins_url('adv-agenda/js/main.js'), array(), '2.0.0', true);
}

add_action('widgets_init', 'adv_agenda_crear_widget');
add_action('wp_enqueue_scripts', 'adv_agenda_css');


// AJAX SECTION //


add_action("wp_ajax_adv_my_update_timestamp", "hey_youre_logged");
add_action("wp_ajax_nopriv_adv_my_update_timestamp", "hey_must_login");

function hey_youre_logged(){
	if(!empty($_SERVER['HTTP_X_REQUESTED_WITH']) && strtolower($_SERVER['HTTP_X_REQUESTED_WITH']) == 'xmlhttprequest') {
		$result = json_encode(array('timestamp'=>time()));
		echo $result;
	}
	else {
		header("Location: ".$_SERVER["HTTP_REFERER"]);
	}
	die();
}

function hey_must_login() {
	#hey_youre_logged();
	//die("You must log in to vote");
	die( json_encode(array('timestamp'=>"You must log in to vote")) );
}


add_action( 'init', 'adv_agenda_script_enqueuer' );

function adv_agenda_script_enqueuer() {
   #wp_register_script( "adv_agenda_timestamp_script", WP_PLUGIN_URL.'/adv-agenda/js/update_timestamp.js', array('jquery') );
   wp_register_script( "adv_agenda_timestamp_script", plugins_url('adv-agenda/js/update_timestamp.js'), array('jquery') );
   wp_localize_script( 'adv_agenda_timestamp_script', 'myAjax', array( 'ajaxurl' => admin_url( 'admin-ajax.php' )));        

   wp_enqueue_script( 'jquery' );
   wp_enqueue_script( 'adv_agenda_timestamp_script' );
}

