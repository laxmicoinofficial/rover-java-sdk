package org.rover.sdk;

import org.rover.sdk.xdr.MemoType;

import java.nio.charset.Charset;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Represents MEMO_TEXT.
 */
public class MemoText extends Memo {
  private String text;

  public MemoText(String text) {
    this.text = checkNotNull(text, "text cannot be null");

    int length = text.getBytes((Charset.forName("UTF-8"))).length;
    if (length > 28) {
      throw new MemoTooLongException("text must be <= 28 bytes. length=" + String.valueOf(length));
    }
  }

  public String getText() {
    return text;
  }

  @Override
  org.rover.sdk.xdr.Memo toXdr() {
    org.rover.sdk.xdr.Memo memo = new org.rover.sdk.xdr.Memo();
    memo.setDiscriminant(MemoType.MEMO_TEXT);
    memo.setText(text);
    return memo;
  }
}
