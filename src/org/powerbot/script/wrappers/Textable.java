package org.powerbot.script.wrappers;

import org.powerbot.script.lang.Filter;

public interface Textable {
	public String getText();

	public interface Query<T> {
		public T text(String... texts);
	}

	public class Matcher implements Filter<Textable> {
		private final String[] texts;

		public Matcher(String... texts) {
			this.texts = new String[texts.length];
			for (int i = 0; i < texts.length; i++) {
				this.texts[i] = texts[i].toLowerCase();
			}
		}

		@Override
		public boolean accept(Textable t) {
			String str = t.getText();
			if (str == null) {
				return false;
			}
			str = str.toLowerCase();
			for (String text : texts) {
				if (text != null && text.contains(str)) {
					return true;
				}
			}
			return false;
		}
	}
}
