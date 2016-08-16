<?php
// Since the cck date field is not in UNIX timestamp format, convert first
date_default_timezone_set('America/Santo_Domingo');

#$field_raw_value = $fields['field_date_value']->raw
$field_raw_value = $row->field_field_date[0]['raw']['value'];
date_default_timezone_set ( $row->field_field_date[0]['raw']['timezone'] );


#echo '<!-- ',var_dump($row),' -->';
$timestamp = strtotime($field_raw_value);
$data_ym = date("Y-n-j", $timestamp);
$ev_month = format_date($timestamp, 'custom', 'M');
$ev_day = format_date($timestamp, 'custom', 'd');
?>

<div class="upcoming-date" data-ymd="<?php print "$data_ym"; ?>" data-nid="<?php print $row->nid?>">

<?php 
$str_perm = 'administer nodes';
#$str_perm = 'edit evento';

if (user_access($str_perm)): ?>
<a href="/?q=node/<?php print $row->nid; ?>/edit" class="editar_evento" title="editar">editar</a>
<?php endif; ?>

<span class="day"><?php print "$ev_day"; ?></span>
<span class="month"><?php print "$ev_month"; ?></span>
</div>
