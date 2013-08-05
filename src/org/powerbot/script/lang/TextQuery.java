package org.powerbot.script.lang;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.Textable;

public abstract class TextQuery<K extends Textable> extends AbstractQuery<TextQuery<K>, K>
		implements Textable.Query<TextQuery<K>> {
	public TextQuery(final MethodContext factory) {
		super(factory);
	}

	@Override
	protected TextQuery<K> getThis() {
		return this;
	}

	@Override
	public TextQuery<K> text(String... texts) {
		return select(new Textable.Matcher(texts));
	}
}
