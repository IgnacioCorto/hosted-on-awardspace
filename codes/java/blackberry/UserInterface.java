package com.rim.samples.userinterface;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.container.*;

public class UserInterface extends UiApplication {
	public static void main(String[] args) {
		UserInterface theApp = new UserInterface();
		theApp.enterEventDispatcher();
	}

	public UserInterface() {
		pushScreen(new UserInterfaceScreen());
	}
}

final class UserInterfaceScreen extends MainScreen {
	HorizontalFieldManager _fieldManagerTop;
	VerticalFieldManager _fieldManagerMiddle;
	HorizontalFieldManager _fieldManagerBottom;
	BitmapField _bitmap;
	Bitmap _canadaImage, _ukImage, _usImage;
	LabelField _label;
	BasicEditField _input;
	String _canadaCapital, _ukCapital, _usCapital, _capital;
	int displayed = 0;

	public UserInterfaceScreen() {
		super();
		LabelField title = new LabelField("User Interface Sample",
				LabelField.ELLIPSIS | LabelField.USE_ALL_WIDTH);
		setTitle(title);
		_fieldManagerTop = new HorizontalFieldManager();
		_fieldManagerMiddle = new VerticalFieldManager();
		_fieldManagerBottom = new HorizontalFieldManager();
		add(_fieldManagerTop);
		add(new SeparatorField());
		add(_fieldManagerMiddle);
		add(new SeparatorField());
		add(_fieldManagerBottom);
		_canadaImage = Bitmap.getBitmapResource("canada.png");
		_ukImage = Bitmap.getBitmapResource("uk.png");
		_usImage = Bitmap.getBitmapResource("us.png");
		_bitmap = new BitmapField();
		_bitmap.setBitmap(_canadaImage);
		_fieldManagerTop.add(_bitmap);
		_canadaCapital = "Ottawa";
		_ukCapital = "London";
		_usCapital = "Washington";
		_capital = _canadaCapital;
		_label = new LabelField("Please press a button!");
		_input = new BasicEditField("Capital (can be changed): ", _capital);
		_fieldManagerMiddle.add(_label);
		_fieldManagerMiddle.add(_input);
		FieldChangeListener listenerCanada = new FieldChangeListener() {
			public void fieldChanged(Field field, int context) {
				_bitmap.setBitmap(_canadaImage);
				_input.setText(_canadaCapital);
				displayed = 0;
			}
		};
		FieldChangeListener listenerUK = new FieldChangeListener() {
			public void fieldChanged(Field field, int context) {
				_bitmap.setBitmap(_ukImage);
				_input.setText(_ukCapital);
				displayed = 1;
			}
		};
		FieldChangeListener listenerUS = new FieldChangeListener() {
			public void fieldChanged(Field field, int context) {
				_bitmap.setBitmap(_usImage);
				_input.setText(_usCapital);
				displayed = 2;
			}
		};
		ButtonField canadaButton = new ButtonField("Canada");
		ButtonField ukButton = new ButtonField(" UK ");
		ButtonField usButton = new ButtonField(" USA ");
		canadaButton.setChangeListener(listenerCanada);
		ukButton.setChangeListener(listenerUK);
		usButton.setChangeListener(listenerUS);
		_fieldManagerBottom.add(canadaButton);
		_fieldManagerBottom.add(ukButton);
		_fieldManagerBottom.add(usButton);
	}

	protected void makeMenu(Menu menu, int instance) {
		menu.add(_changeCapital);
		menu.add(_close);
	}

	private MenuItem _changeCapital = new MenuItem("Change Capital", 110, 10) {
		public void run() {
			if (displayed == 0)
				_canadaCapital = _input.getText();
			else if (displayed == 1)
				_ukCapital = _input.getText();
			else if (displayed == 2)
				_usCapital = _input.getText();
		}
	};
	private MenuItem _close = new MenuItem("Close", 110, 10) {
		public void run() {
			onClose();
		}
	};

	public boolean onClose() {
		Dialog.alert("Goodbye!");
		System.exit(0);
		return true;
	}
}
