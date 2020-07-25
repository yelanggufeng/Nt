var langs = new Array();
langs["zh_CH"]=new Array();
langs["en_US"]=new Array();
function LT(key)
{
	if(langs[_lang][key]==null)
	{
		return key;
	}

	return langs[_lang][key];
}

//菜单
langs["zh_CH"]["Storage:node"]="存储节点";
langs["zh_CH"]["add"]="添加";
langs["zh_CH"]["No."]="序号";
langs["zh_CH"]["Storage:IP"]="IP";
langs["zh_CH"]["Storage:port"]="端口";
langs["zh_CH"]["Storage:username"]="用户名";
langs["zh_CH"]["Storage:psd"]="密码";
langs["zh_CH"]["Storage:details"]="详情";

langs["zh_CH"]["Hardware:RES"]="硬件资源";


//英文翻译====================================================================================================
//英文翻译====================================================================================================


langs["en_US"]["Storage:node"]="Storage Node";
langs["en_US"]["add"]="Add";
langs["en_US"]["No."]="No.";
langs["en_US"]["Storage:port"]="Port";
langs["en_US"]["Storage:psd"]="Password";
langs["en_US"]["Storage:details"]="details";

langs["en_US"]["Hardware:RES"]="Hardware Resource";




