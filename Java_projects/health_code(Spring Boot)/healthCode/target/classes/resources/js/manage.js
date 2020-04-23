//@ sourceURL=js/manage.js
// 上面的代码 后面路径写js文件的路径 保证浏览器在调试时 可以加载到该js页面
var vm = new Vue({
		el: "#phase",
		data: {
			pageInfo:{},
			list: [],
			isUpdate: false, // 标记是否是修改操作
			msPhase: {}, // 保存新增和修改的数据对象
			queryCondition: {}, // 保存查询条件
			type: 1, //1不显示 2成功 3失败
			valid: [true,true],//记录表单数据校验结果 默认都是通过的
			flag: true,//标记是否可以提交数据 默认可以
			isIndex: true,
			isEdit: false,
			right:false
		},
		
		methods:{
			goPage: function(pageNum){
				// 查询条件中携带要查询的页码
				this.queryCondition.pageNum = pageNum;
				var params = {
						params:this.queryCondition
				}
				this.$http.get("user/admin",params).then(
						(resp) => {
							this.pageInfo = resp.body;
							this.list = resp.body.list;
							//console.log(this.pageInfo);
						},
						(resp) => {
							
						}
				);
			},
			// 点击新增按钮
			addDiv: function(){
				this.isUpdate = false;
				this.msPhase = {};//清空表单数据
				this.valid = [true,true];
				this.flag = true;
				this.isIndex = false;
				this.isEdit = true;
			},
			//点击修改按钮
			modify: function(index){
				this.isUpdate = true;
				this.msPhase = {};//清空表单数据
				this.valid = [true,true];
				this.flag = true;
				this.isIndex = false;
				this.isEdit = true;
				this.msPhase.userid = this.list[index].userid;
			},
			// 点击保存按钮操作
			save: function(){
				// 数据校验
				var usernameOk = /^[a-zA-Z0-9]{1,10}$/.test(this.msPhase.username);
				var passwordOk = /^[[a-zA-Z0-9]{3,6}$/.test(this.msPhase.password);
				
				if(usernameOk && passwordOk){
					this.flag = true;
				}else{
					this.flag = false;
				}
				this.valid = [usernameOk,passwordOk];
				
				
				
				
				
				if(this.flag){// 可以提交
					if(this.isUpdate){
						url = "user/update";
					}else{
						url = "user/insert";
					}
				
					this.$http.post(url,this.msPhase,{emulateJSON: true}).then(
							(resp) => {
								var r = resp.bodyText;
								//切换显示页面
								this.isIndex = true;
								this.isEdit = false;
								if(r == "success"){
									//刷新当前页
									if(this.isUpdate){
										this.goPage(this.pageInfo.pageNum);
									}
									this.type = 2;
								}else{
									this.type = 3;
								}
								setTimeout('vm.type = 1',3000);
								this.msPhase = {};
							},
							(resp) => {
								
							}
					);
					
				}
				
				
				
			},
			//删除按钮操作
			delet: function(index){
				var msg = "您确定要删除该用户？";
		        if (confirm(msg)==true){
					var userid = this.list[index].userid;
					var data = {
							userid:userid
						};
					var params = {
						params : data
					};
					this.$http.get("user/delete",params).then(
							(resp) => {
								if(resp.bodyText == "success"){
									//刷新页面
									this.gopage(1);
									this.type = 2;
								}else{
									this.type = 3;
								}
								setTimeout('vm.type = 1',3000);
							},
							(resp) => {
								
							}
					);
				}
			},
			//查询当前登录用户权限的方法
			userRole: function(){
				this.$http.get("user/selRole").then(
						(resp) => {
							if(resp.bodyText == "ok"){
								//有管理员权限，显示删除修改操作
								this.right = true;
							}else{
								this.right = false;
							}
						},
						(resp) => {
							
						}
				);
			}
		}
	});
	vm.userRole();//查询当前登录用户 的权限
	vm.goPage(1); // 显示第1页数据