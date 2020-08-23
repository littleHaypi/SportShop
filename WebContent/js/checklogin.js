let login=new Vue({
	el:"#login_info",
	data:{
		onlogin:false,
		loginName:"匿名",
		loginId:"",
		cartCount:0,
		carts:[],
		photo:""
	},mounted:function(){
		axios.get("user",{params:{op:"info"}}).then(result=>{
	
		if(result.data.code==200){
			//说明已经登录
			this.onlogin=true;
			this.loginName=result.data.data.uname;
			this.loginId=result.data.data.uid;
			this.photo=result.data.data.photo;
		}else{
			this.onlogin=false;
		}
		}),
		axios.get("cart",{params:{op:"info"}}).then(result=>{
			
			if(result.data.code==201){
			   this.cartCount=result.data.data.length;
			   this.carts=result.data.data;
				
			}else{
				this.cartCount=0;
			}
			})
	}
})		
		
		
//	
//		axios.all([checkLogin(),getCartInfo()]).then(axios.spread((fn1,fn2)=>{
//			console.info("发送了");
//			if(fn1.data.code==200){
//			this.onlogin=true;
//			this.loginName=result.data.data.nickName;
//			this.loginId=result.data.data.mno;
//			}else{
//				this.onlogin=false;
//			}
//			
//			if(fn2.data.code==200){
//				
//			}else{
//				this.cartCount=0;
//			}
//		}))

function checkLogin(){
	return axios.get("user",{params:{op:"info"}});
}
function getCartInfo(){
	return axios.get("cart",{params:{op:"info"}});
}