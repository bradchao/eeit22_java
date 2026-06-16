window.onload = function(){
	let clear = document.getElementById("clear");
	let myDrawer = document.getElementById("myDrawer");
	let url = "ws://10.0.101.218/BradWeb2/mycenter"
	let webSocket = new WebSocket(url);
	
	webSocket.onopen = function(){}
	webSocket.onmessage = function(){}
	webSocket.onclose = function(){}
	
	//-------------------------
	let isDrag = false;
	let ctx = myDrawer.getContext("2d");
	myDrawer.onmousedown = function(e){
		isDrag = true;
		let x = e.offsetX, y = e.offsetY;
		ctx.lineWidth = 4;
		ctx.beginPath();
		ctx.moveTo(x, y);
		
	}
	myDrawer.onmouseup = function(e){
		isDrag = false;
	}
	myDrawer.onmousemove = function(e){
		if (isDrag){
			let x = e.offsetX, y = e.offsetY;
			ctx.lineTo(x,y);
			ctx.stroke();
		}
	}
	
}