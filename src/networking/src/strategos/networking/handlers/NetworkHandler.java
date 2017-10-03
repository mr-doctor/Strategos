package strategos.networking.handlers;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import strategos.SaveInstance;
import strategos.networking.Network;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles the top level Networking
 */
public class NetworkHandler extends SimpleChannelInboundHandler<SaveInstance> {

	private List<ChannelHandlerContext> connections = new ArrayList<>();
	private Network network;

	/**
	 * Creates a new network handler with the provided {@code Network}
	 * @param network The network to construct the handler with
	 */
	public NetworkHandler(Network network) {
		this.network = network;
	}

	@Override
	public void channelActive(final ChannelHandlerContext ctx) throws Exception {
		super.channelActive(ctx);
		connections.add(ctx);
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		super.channelInactive(ctx);
		connections.remove(ctx);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}


	/**
	 * Sends the provided SaveInstance to each connection
	 * @param instance The SaveInstance to send
	 */
	public void send(SaveInstance instance) {
		connections.forEach(conn-> conn.writeAndFlush(instance));
	}

	@Override
	protected void messageReceived(ChannelHandlerContext ctx, SaveInstance msg) throws Exception {
        network.receive(msg);
	}
}
