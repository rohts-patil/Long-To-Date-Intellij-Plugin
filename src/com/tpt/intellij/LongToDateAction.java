package com.tpt.intellij;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.ui.Messages;

import java.util.Calendar;
import java.util.TimeZone;

/*
 * @author rohit.patil
 */
public class LongToDateAction extends AnAction {

  @Override
  public void actionPerformed(AnActionEvent event) {
    final Editor editor = event.getRequiredData(CommonDataKeys.EDITOR);
    CaretModel caretModel = editor.getCaretModel();

    String dataUTC =
        MillisToDate.convert(
            Long.parseLong(caretModel.getCurrentCaret().getSelectedText()),
            TimeZone.getTimeZone("UTC"));

    String dataLocal =
        MillisToDate.convert(
            Long.parseLong(caretModel.getCurrentCaret().getSelectedText()),
            Calendar.getInstance().getTimeZone());

    Messages.showMessageDialog(
        "UTC:-\n"
            + dataUTC
            + "\n"
            + Calendar.getInstance().getTimeZone().getID()
            + ":-\n"
            + dataLocal,
        "Long to Date",
        Messages.getInformationIcon());
  }

  /**
   * Only make this action visible when text is selected.
   *
   * @param event
   */
  @Override
  public void update(AnActionEvent event) {
    final Editor editor = event.getRequiredData(CommonDataKeys.EDITOR);
    CaretModel caretModel = editor.getCaretModel();
    event.getPresentation().setEnabledAndVisible(caretModel.getCurrentCaret().hasSelection());
  }
}
