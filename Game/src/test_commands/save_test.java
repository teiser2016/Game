 SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
 editor.putString("text", mSaved.getText().toString());
 editor.putInt("selection-start", mSaved.getSelectionStart());
 editor.putInt("selection-end", mSaved.getSelectionEnd());
 editor.apply();