<?php
/**
 * @file views-view-fields.tpl.php
 * Default simple view template to all the fields as a row.
 *
 * - $view: The view in use.
 * - $fields: an array of $field objects. Each one contains:
 *   - $field->content: The output of the field.
 *   - $field->raw: The raw data for the field, if it exists. This is NOT output safe.
 *   - $field->class: The safe class id to use.
 *   - $field->handler: The Views field handler object controlling this field. Do not use
 *     var_export to dump this object, as it can't handle the recursion.
 *   - $field->inline: Whether or not the field should be inline.
 *   - $field->inline_html: either div or span based on the above flag.
 *   - $field->wrapper_prefix: A complete wrapper containing the inline_html to use.
 *   - $field->wrapper_suffix: The closing tag for the wrapper.
 *   - $field->separator: an optional separator that may appear before a field.
 *   - $field->label: The wrap label text to use.
 *   - $field->label_html: The full HTML of the label to use including
 *     configured element type.
 * - $row: The raw result object from the query, with all data it fetched.
 *
 * @ingroup views_templates
 */


$direct_title = $row->_field_data['nid']['entity']->title;
$direct_body = $row->_field_data['nid']['entity']->body['und'][0]['value'];
$direct_url = $row->_field_data['nid']['entity']->field_extra_url['und'][0]['value'];
#echo '<!-- ', var_dump($row->_field_data['nid']['entity']->field_image), ' -->';

$link_data = array();

foreach ($fields as $id => $field):
	$link_data[ $field->class ] = $field->content;
endforeach;
#echo '<!-- IMAGEN: ', var_dump($link_data), ' -->';


$link_data['field-url'] = $direct_url;

echo <<<EOT
<div class="dd_preview">
<a href="javascript:void(0);" onclick="dd_lightbox({$row->nid});">{$link_data['field-image']}<h3>{$link_data['title']}</h3></a>
</div>

<div class="dd_detail jqmWindow" id="dd_det_{$row->nid}" style="display:none;">
<div class="dd_det_image">{$link_data['field-image-1']}</div>
<div class="dd_det_data">
<h3>{$link_data['title']}</h3>
<div class="dd_det_descr">{$link_data['body']}</div>
<a href="{$link_data['field-url']}" target="_blank" class="descargar">descargar</a>
</div>
</div>
EOT;


/*
<?php foreach ($fields as $id => $field): ?>
  <?php if (!empty($field->separator)): ?>
    <?php print $field->separator; ?>
  <?php endif; ?>

  <?php print $field->wrapper_prefix; ?>
    <?php print $field->label_html; ?>
    <?php print $field->content; ?>
  <?php print $field->wrapper_suffix; ?>
<?php endforeach; ?>
*/