SharedPreferences prefs = getPreferences(MODE_PRIVATE); 
String restoredText = prefs.getString("text", null);
if (restoredText != null) 
{
  //mSaved.setText(restoredText, TextView.BufferType.EDITABLE);
  int selectionStart = prefs.getInt("selection-start", -1);
  int selectionEnd = prefs.getInt("selection-end", -1);
  /*if (selectionStart != -1 && selectionEnd != -1)
  {
     mSaved.setSelection(selectionStart, selectionEnd);
  }*/
}