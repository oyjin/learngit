//@ sourceURL=js/statistic.js
// 上面的代码 后面路径写js文件的路径 保证浏览器在调试时 可以加载到该js页面
var vm = new Vue({
		el: "#statistics",
		data: {
			pageInfo:{},
			list: [],	//车点信息
			queryCondition: {}, // 保存查询条件
			name:"",	//车点名称
			number:"",	//车桩数量
			usage:{}	//返回的使用率信息
		},
		
		methods:{
			goPage: function(pageNum){
				// 查询条件中携带要查询的页码
				this.queryCondition.pageNum = pageNum;
				var params = {
						params:this.queryCondition
				};
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
			
			//显示统计数据页面的方法
			showData: function(index){
				this.name = this.list[index].station_name;
				this.number = this.list[index].bicycle_pile_num;
				var station_id = this.list[index].station_id;
				var data={
						station_id:station_id
				};
				var params = {
						params:data
				};
				this.$http.get("statistic/select",params).then(
						(resp) => {
							this.usage = resp.body;
						},
						(resp) => {
							
						}
				);
			}
			
		}
	});
	
	vm.goPage(1); // 显示第1页数据