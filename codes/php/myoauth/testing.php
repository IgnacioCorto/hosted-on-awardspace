<?php
echo '<pre>';

echo rawurldecode('GET&https%3A%2F%2Fapi.dropbox.com%2F0%2Faccount%2Finfo&oauth_callback%3D%26oauth_consumer_key%3D********%26oauth_nonce%3D5f38dbc02a97567965f14d%26oauth_signature_method%3DHMAC-SHA1%26oauth_timestamp%3D1308789349%26oauth_token%3Dr439hrnysbdcer4%26oauth_version%3D1.0');

print_r(hash_algos());
