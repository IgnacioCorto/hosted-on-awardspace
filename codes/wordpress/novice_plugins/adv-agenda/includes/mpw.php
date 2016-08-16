<?php

class adv_agenda extends WP_Widget {

    /**
     *  Constructor del Widget. 
     */
    function adv_agenda() {
        $widget_ops = array('classname' => 'adv_agenda', 'description' => "Mostrar actividades en la agenda.");
        $this->WP_Widget('adv_agenda', "Agenda - Primera Dama", $widget_ops);
    }

    /**
     * Contenido del Widget que se mostrarÃ¡ en la Sidebar 
     */
    function widget($args, $instance) {
        echo $before_widget;
        ?>
        <aside id='mpw_widget' class='widget myp_widget'>
            <h3 class='widget-title'>Agenda - Primera Dama</h3>
            <p><?= $instance["adv_agenda_texto"] ?></p>
        </aside>
		<hr />    
    
    <!-- ignacio debug
    
	<?php
$paged = ( get_query_var('paged') ) ? get_query_var('paged') : 1;
$upcoming = new WP_Query();
$upcoming->query( array(
	'orderby'=> 'EventStartDate',
	'order'=> 'DESC',
	'post_type'=> 'tribe_events',
	'eventDisplay' => 'past',
	'posts_per_page' => 1,
	'paged' => $paged)
);

if ($upcoming->have_posts()) :
	while ($upcoming->have_posts()) :
		$upcoming->the_post();
		?>
		<div class="single-event">
			<div class="title">
				<a href="<?php the_permalink() ?>" rel="bookmark"><?php the_title(); ?>
                 -- <?php echo tribe_get_start_date($upcoming->ID, true, 'Y-m-d H:i:s'); ?></a>
			</div>
		</DIV>
	<?php
	endwhile;
	if ( function_exists('wp_pagenavi') ) wp_pagenavi( array( 'query' => $upcoming ) ); // tell it which query we are paginating
endif;
wp_reset_query(); // important to reset the query	
	?>
    -->
    
    
    <?php
	// AJAX SECTION //
	
	$link = admin_url('admin-ajax.php?action=adv_my_update_timestamp');
	
	echo "
		<div class='current_timestamp'></div>
		<a class='update_timestamp' href='$link'>...</a>
		";
	?>
    
    
    
    
    	
        <?php echo $after_widget;
    }

    /* Funcion para guardar los datos de configuraciÃ³n */

    function update($new_instance, $old_instance) {
        $instance = $old_instance;
        $instance["adv_agenda_texto"] = strip_tags($new_instance["adv_agenda_texto"]);
        // Repetimos esto para tantos campos como tengamos en el formulario.
        return $instance;
    }

    /* Formulario de opciones del Widget, que aparece cuando aÃ±adimos el Widget a una Sidebar */

    function form($instance) {
        ?>
        <p>
        <label for="<?php echo $this->get_field_id('adv_agenda_texto'); ?>">Texto del Widget</label>
        <input class="widefat" id="<?php echo $this->get_field_id('adv_agenda_texto'); ?>" 
            name="<?php echo $this->get_field_name('adv_agenda_texto'); ?>" 
            value="<?php echo esc_attr($instance["adv_agenda_texto"]); ?>"
            type="text"  />
        </p>  
        <?php
    }

}