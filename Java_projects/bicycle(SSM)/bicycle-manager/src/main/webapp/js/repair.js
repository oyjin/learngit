//@ sourceURL=js/repair.js
// 上面的代码 后面路径写js文件的路径 保证浏览器在调试时 可以加载到该js页面
var vm = new Vue({
		el: "#repair",
		data: {
			pageInfo:{},
			list: [],
			repair: {}, // 保存维修信息的数据对象
			valid: [true,true,true,true,true],//记录表单数据校验结果 默认都是通过的
			flag: true, //标记是否可以提交数据 默认可以
			bicycles: [],	//存放维修成功的车辆信息
			piles: [],		//存放无车的车桩对象
			checkbi: "",	//选中的车辆索引
			checkpi: ""		//选中的车桩索引
		},
		
		methods:{
			goPage: function(pageNum){
				var data= {
						pageNum:pageNum
				};
				var params = {
						params:data
				};
				this.$http.get("repair/select",params).then(
						(resp) => {
							this.pageInfo = resp.body;
							this.list = resp.body.list;
							//console.log(this.pageInfo);
						},
						(resp) => {
							
						}
				);
			},
			//点击维修登记按钮操作
			fixRegist: function(index){
				this.repair = {};	//清空表单数据
				this.repair.bicycle_id = this.list[index].bicycle_id;
				this.valid = [true,true,true,true,true];
				this.flag = true;
			},
			
			// 点击保存按钮操作
			save: function(){
				// 数据校验
				var typeOk = this.repair.repair_type != null && this.repair.repair_type != "";
				var partOk = this.repair.repair_part != null && this.repair.repair_part != "";
				var resultOk = this.repair.repair_result != null && this.repair.repair_result != "";
				var feeOk = /^(([1-9]{1}\d*)|(0{1}))(\.\d{2})?$/.test(this.repair.fee);
				var renOk = /^[\u4e00-\u9fa5]{2,10}$/.test(this.repair.repairer);
				
				if(typeOk && partOk && resultOk && feeOk && renOk){
					this.flag = true;
				}else{
					this.flag = false;
				}
				this.valid = [typeOk,partOk,resultOk,feeOk,renOk];
				
				
				
				
				
				if(this.flag){// 可以提交
					
				
					this.$http.post("repair/register",this.repair,{emulateJSON: true}).then(
							(resp) => {
								var r = resp.bodyText;
								//关闭窗口
								$("#optDiv").modal('hide');
								if(r == "success"){
									alert("维修登记成功")
									this.goPage(this.pageInfo.pageNum);	//刷新页面
								}else{
									alert(r);
								}
							},
							(resp) => {
								
							}
					);
					
				}
				
				
				
			},
			
			//请求所有状态为维修成功的车辆信息
			repairIn: function(){
				this.$http.get("repair/success").then(
						(resp) => {
							console.log(resp);
							this.bicycles = resp.body;
						},
						(resp) => {
							console.error("请求失败，"+resp);
						}
				);
			},
			
			//请求所有状态为无车的车桩信息
			showPile: function(){
				this.$http.get("repair/showPile").then(
						(resp) => {
							console.log(resp);
							this.piles = resp.body;
						},
						(resp) => {
							console.error("请求失败，"+resp);
						}
				);
				
			},
			
			//维修调入操作
			comit: function(){
				var Bindex=this.checkbi;
				var Pindex=this.checkpi;
				var bicycle_id="";
				var pile_id = "";
				if(Bindex.length==0 || Pindex.length == 0){
					alert("必须选择车辆和车桩！");
				}else{
					bicycle_id = this.bicycles[Bindex].bicycle_id;
					pile_id = this.piles[Pindex].pile_id; 
					
					var data={
							bicycle_id:bicycle_id,
							pile_id:pile_id
					};
					var params={
							params:data
					};
					this.$http.get("repair/repairIn",params).then(
							(resp) => {
								var r = resp.bodyText;
								//关闭窗口
								$("#ooptDiv").modal('hide');
								$("#spiDiv").modal('hide');
								if(r == "success"){
									alert("调入成功！")
									this.goPage(this.pageInfo.pageNum);	//刷新页面
								}else{
									alert(r);
									this.goPage(this.pageInfo.pageNum);
								}
							},
							(resp) => {
								console.error("请求失败，"+resp);
							}
						);
				}
			}
		}
	});
	
	vm.goPage(1); // 显示第1页数据