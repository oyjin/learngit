//@ sourceURL=js/bicycle.js
// 上面的代码 后面路径写js文件的路径 保证浏览器在调试时 可以加载到该js页面
var vm = new Vue({
		el: "#pile",
		data: {
			pageInfo:{},
			list: [],	//车点信息
			pile: [],	//车桩_车辆信息
			queryCondition: {} // 保存查询条件
		},
		
		methods:{
			goPage: function(pageNum){
				// 查询条件中携带要查询的页码
				this.queryCondition.pageNum = pageNum;
				var params = {
						params:this.queryCondition
				}
				this.$http.get("bicycle/select",params).then(
						(resp) => {
							this.pageInfo = resp.body;
							this.list = resp.body.list;
							//console.log(this.pageInfo);
						},
						(resp) => {
							
						}
				);
			},
			
			//显示车桩的方法
			showPile: function(index){
				var station_id = this.list[index].station_id;
				var data = {
						station_id:station_id
					};
				var params = {
					params : data
				};
				this.$http.get("bicycle/selectpile",params).then(
						(resp) => {
							this.pile = resp.body;
							for(var i=0;i<this.pile.length;i++){
								if(this.pile[i].status == 1){
									this.pile[i].status="有车";
								}else{
									this.pile[i].status="无车";
								}
							}
							//console.log(this.pageInfo);
						},
						(resp) => {
							
						}
				);
			}
		}
	});
	
	vm.goPage(1); // 显示第1页数据