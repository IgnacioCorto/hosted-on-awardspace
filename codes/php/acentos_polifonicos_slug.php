	function quitarAcentos($search){
		$replace = ' ';
		
		$trans = array(
						"�" => 'a',
						"�" => 'e',
						"�" => 'i',
						"�" => 'o',
						"�" => 'u',
						"�" => 'a',
						"�" => 'e',
						"�" => 'i',
						"�" => 'o',
						"�" => 'u',
						"�" => 'n',
						"�" => 'a',
						"�" => 'e',
						"�" => 'i',
						"�" => 'o',
						"�" => 'u',
						"�" => 'N',
						"�" => 'A',
						"�" => 'E',
						"�" => 'I',
						"�" => 'O',
						"�" => 'U',
						"�" => 'A',
						"�" => 'E',
						"�" => 'I',
						"�" => 'O',
						"�" => 'U',
						"�" => 'A',
						"�" => 'E',
						"�" => 'I',
						"�" => 'O',
						"�" => 'U',
						"�" => 'C',
						"�" => 'c',
						'&\#\d+?;'				=> '',
						'&\S+?;'				=> '',
						#'\s+'					=> $replace,
						#'[^a-z0-9\-\._]'		=> '',
						$replace.'+'			=> $replace,
						$replace.'$'			=> $replace,
						'^'.$replace			=> $replace,
						'\.+$'					=> ''
					);

		$str = strip_tags($search);

		foreach ($trans as $key => $val)
		{
			$str = preg_replace("#".$key."#i", $val, $str);
		}

		return trim(stripslashes($str));
	}