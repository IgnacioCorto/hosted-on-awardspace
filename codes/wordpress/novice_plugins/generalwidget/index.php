<?php
/*
Plugin Name: General Widget
Plugin URI: http://yourdomain.com/
Description: General widget for placeholding web content
Version: 1.0
Author: Balakrishnan
Author URI: http://yourdomain.com
License: GPL
*/

function pul_crear_widget() {
    include_once(plugin_dir_path(__FILE__) . '/includes/mpw.php');
    register_widget('pul_noticias');
}

function penlaces_css() {
   wp_register_style('pul_noticias-enlaces', plugins_url('generalwidget/css/main.css'));
   wp_enqueue_style('pul_noticias-enlaces');
   wp_enqueue_script('pul_noticias-enlaces', plugins_url('generalwidget/js/main.js'), array(), '2.0.0', true);
}

add_action('widgets_init', 'pul_crear_widget');
add_action('wp_enqueue_scripts', 'penlaces_css');
