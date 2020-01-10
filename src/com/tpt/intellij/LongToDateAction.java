package com.tpt.intellij;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.ui.Messages;

public class LongToDateAction extends AnAction {
  /**
   * Convert selected text to a URL friendly string.
   *
   * @param event
   */
  @Override
  public void actionPerformed(AnActionEvent event) {
    final Editor editor = event.getRequiredData(CommonDataKeys.EDITOR);
    CaretModel caretModel = editor.getCaretModel();

    Messages.showMessageDialog(
        MillisToDate.convert(Long.parseLong(caretModel.getCurrentCaret().getSelectedText())),
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
