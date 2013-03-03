package org.powerbot.core.script.methods;

import java.util.HashSet;
import java.util.Set;

import org.powerbot.core.Bot;
import org.powerbot.core.script.internal.wrappers.Deque;
import org.powerbot.core.script.wrappers.Projectile;
import org.powerbot.game.client.Client;
import org.powerbot.game.client.Node;
import org.powerbot.game.client.NodeDeque;
import org.powerbot.game.client.RSProjectile;
import org.powerbot.game.client.RSProjectileNode;

public class Projectiles {
	public static Set<Projectile> getLoaded() {
		final Client client = Bot.client();
		if (client == null) return new HashSet<>(0);

		final NodeDeque deque = client.getProjectileDeque();
		if (deque == null) return new HashSet<>(0);

		final Set<Projectile> projectiles = new HashSet<>();
		final Deque<Node> nodes = new Deque<>(deque);
		for (Node node = nodes.getHead(); node != null; node = nodes.getNext()) {
			final RSProjectile projectile;
			if (node instanceof RSProjectileNode && (projectile = ((RSProjectileNode) node).getProjectile()) != null) {
				projectiles.add(new Projectile(projectile));
			}
		}
		return projectiles;
	}
}
