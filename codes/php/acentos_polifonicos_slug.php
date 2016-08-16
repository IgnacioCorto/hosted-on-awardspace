	function quitarAcentos($search){
		$replace = ' ';
		
		$trans = array(
						"á" => 'a',
						"é" => 'e',
						"í" => 'i',
						"ó" => 'o',
						"ú" => 'u',
						"à" => 'a',
						"è" => 'e',
						"ì" => 'i',
						"ò" => 'o',
						"ù" => 'u',
						"ñ" => 'n',
						"ä" => 'a',
						"ë" => 'e',
						"ï" => 'i',
						"ö" => 'o',
						"ü" => 'u',
						"Ñ" => 'N',
						"Á" => 'A',
						"É" => 'E',
						"Í" => 'I',
						"Ó" => 'O',
						"Ú" => 'U',
						"À" => 'A',
						"È" => 'E',
						"Ì" => 'I',
						"Ò" => 'O',
						"Ù" => 'U',
						"Ä" => 'A',
						"Ë" => 'E',
						"Ï" => 'I',
						"Ö" => 'O',
						"Ü" => 'U',
						"Ç" => 'C',
						"ç" => 'c',
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