var _lang = "zh_CH";


function start_stream(ip, user, passwd, type, chan, funcrsp){
	var msg={};
	msg.opcmd="startstream";
	msg.devip=ip;
	msg.username=user;
	msg.passwd=passwd;
	msg.devtype = type;
	msg.chan=chan;
	console.log(msg);
    $.ajax({
		type: "post",
		async: false,
		cache: false,
		url: "http://112.81.63.213:19666/opdag",
		contentType: "application/json", 
		timeout:5000,
        data: JSON.stringify(msg),
		success: funcrsp,
		error: function(XMLHttpRequest, textStatus, errorThrown){
			console.log(textStatus);
		}
	});    
}

function stop_stream(session){
	var msg={};
	msg.opcmd="stopstream";
	msg.session = session;
	console.log(msg);
    $.ajax({
		type: "post",
		async: false,
		cache: false,
		url: "http://112.81.63.213:19666/opdag",
		contentType: "application/json", 
		timeout:5000,
        data: JSON.stringify(msg),
		error: function(XMLHttpRequest, textStatus, errorThrown){
			console.log(textStatus);
		}
	});    
}

//cmd, 控制命令 21-上 22-下 23-左 24-右 25-左上 26-右上 27-左下 28-右下
//state 0-开始 1-停止
function ptz_ctrl(session, cmd, state){
	var msg={};
	msg.opcmd="ptzctl";
	msg.session = session;
	msg.cmd=cmd;
	msg.state=state;
	console.log(msg);
    $.ajax({
		type: "post",
		async: false,
		cache: false,
		url: "http://112.81.63.213:19666/opdag",
		contentType: "application/json", 
		timeout:5000,
        data: JSON.stringify(msg),
		//success: funSuccess,
		error: function(XMLHttpRequest, textStatus, errorThrown){
			console.log(textStatus);
		}
	});    
}


function start_playback(ip, user, passwd, type, chan, starttime, endtime, funcrsp){
	var msg={};
	msg.opcmd="startplayback";
	msg.devip=ip;
	msg.username=user;
	msg.passwd=passwd;
	msg.devtype = type;
	msg.chan=chan;
	msg.starttime=starttime;
	msg.endtime=endtime;
	console.log(msg);
    $.ajax({
		type: "post",
		async: false,
		cache: false,
		url: "http://112.81.63.213:19666/opdag",
		contentType: "application/json", 
		timeout:5000,
        data: JSON.stringify(msg),
		success: funcrsp,
		error: function(XMLHttpRequest, textStatus, errorThrown){
			console.log(textStatus);
		}
	});    
}