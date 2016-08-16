<?php
#status:
#1) not logged
#     - 'state' is optional, to protect from 'Cross-site Request Forgery'
#     - 'response_type' --> code, token, code%20token
#     - 'scope' -->  permissions list (comma-separated)

date_default_timezone_set('America/Santo_Domingo');

$app_id = 'MUMBLE_MUMBLE_MUMBLE';
$app_secret = 'MUMBLE_MUMBLE_MUMBLE';
# expiring token
$access_token = 'MUMBLE_MUMBLE_MUMBLE';

$redirect_uri = 'http://localhost:8888/ignacio/facebook/facebook_http.php';

$login_url = "https://www.facebook.com/dialog/oauth?"
           . "client_id=$app_id"
           . "&redirect_uri=$redirect_uri";
?>

<style>.rojo,.rojo *{color:red !important;}</style>
<pre style="border:3px double black; padding:5px;">
Pending:
 - Handling Error Login
 - Inspecting Tokens
 - <a href="https://developers.facebook.com/docs/facebook-login/access-tokens/">Types of Tokens</a>
 - <a href="https://developers.facebook.com/docs/facebook-login/using-login-with-devices">Login with Devices</a>
</pre>



<p><a href="<?php echo $login_url; ?>">click here to login</a></p>



<?php 
# process 'CODE' after login 
$access_data = array();
if(isset($_REQUEST['code'])){ 
    $access_url = "https://graph.facebook.com/oauth/access_token?"
                . "client_id={$app_id}"
                . "&redirect_uri={$redirect_uri}"
                . "&client_secret={$app_secret}"
                . "&code={$_REQUEST['code']}";
    @parse_str(file_get_contents($access_url), $access_data);
?>
<div class="rojo"><p><h4>Access:</h4> <?php echo '<pre>', var_dump($access_data), '</pre>'; ?></p></div><?php } ?>




<?php 
# getting an  'APP_TOKEN' 
$app_token_url = "https://graph.facebook.com/oauth/access_token?"
            . "client_id={$app_id}"
            . "&client_secret={$app_secret}"
            . "&grant_type=client_credentials";
@parse_str(file_get_contents($app_token_url), $app_token_data);
?>
<p><h4>App Token:</h4> <?php echo '<pre>', var_dump($app_token_data), '</pre>'; ?></p>






<?php
# checking the  'TOKEN_STATUS'
$developer_token = $app_token_data['access_token'];

if(isset($access_data['access_token']) && isset($access_data['expires'])){
    $access_token = $access_data['access_token'];
}

$status_url = "https://graph.facebook.com/debug_token?"
            . "input_token={$access_token}"
            . "&access_token={$developer_token}";
$status_data = file_get_contents($status_url);
$status_json = json_decode($status_data);
?>
<p>
<h4>Status <a href="<?php echo $status_url; ?>" target="_blank">[GO]</a>:</h4>
Generation: <?php echo strftime('%c',$status_json->data->issued_at);?><br />
Expiration: <?php echo strftime('%c',$status_json->data->expires_at);?><br />
<?php echo '<pre>', var_dump($status_json), '</pre>'; ?>
</p>



<?php
# displaying my basic information
$basic_info_url = "https://graph.facebook.com/me?"
            . "fields=id,name"
            . "&access_token={$access_token}";
@$basic_info_data = file_get_contents($basic_info_url);
?>
<p><h4>Basic Info:</h4> <?php echo '<pre>', var_dump($basic_info_data), '</pre>'; ?></p>




<?php 
# END-OF-PROGRAM
echo '<hr /><pre>', var_dump($_REQUEST), '</pre>'; 
?>
