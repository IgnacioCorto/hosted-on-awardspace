<?php

class pul_noticias extends WP_Widget {

    /**
     *  Constructor del Widget. 
     */
    function pul_noticias() {
        $widget_ops = array('classname' => 'pul_noticias', 'description' => "Mostrar la última noticia registrada en Wordpress");
        $this->WP_Widget('pul_noticias', "Presidencia - Última Noticia", $widget_ops);
    }

    /**
     * Contenido del Widget que se mostrará en la Sidebar 
     */
    function widget($args, $instance) {
        echo $before_widget;
        ?>
        <aside id='mpw_widget' class='widget myp_widget'>
            <h3 class='widget-title'>Presidencia</h3>
            <p><?= $instance["pul_texto"] ?></p>
        </aside>
        <?php
        echo $after_widget;
    }

    /* Funcion para guardar los datos de configuración */

    function update($new_instance, $old_instance) {
        $instance = $old_instance;
        $instance["pul_texto"] = strip_tags($new_instance["pul_texto"]);
        // Repetimos esto para tantos campos como tengamos en el formulario.
        return $instance;
    }

    /* Formulario de opciones del Widget, que aparece cuando añadimos el Widget a una Sidebar */

    function form($instance) {
        ?>
        <p>
            <label for="<?php echo $this->get_field_id('pul_texto'); ?>">Texto del Widget</label>
            <input class="widefat" id="<?php echo $this->get_field_id('pul_texto'); ?>" name="<?php echo $this->get_field_name('pul_texto'); ?>" type="text" value="<?php echo esc_attr($instance["pul_texto"]); ?>" />
        </p>  
        <?php
    }

}