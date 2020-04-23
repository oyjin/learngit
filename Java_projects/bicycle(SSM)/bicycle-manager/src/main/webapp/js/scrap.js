//@ sourceURL=js/scrap.js
// 上面的代码 后面路径写js文件的路径 保证浏览器在调试时 可以加载到该js页面
var vm = new Vue({
		el: "#scrap",
		data: {
			pageInfo:{},
			list: []	//车点信息
		},
		
		methods:{
			goPage: function(pageNum){
				var data= {
						pageNum:pageNum
				};
				var params = {
						params:data
				};
				this.$http.get("scrap/select",params).then(
						(resp) => {
							this.pageInfo = resp.body;
							this.list = resp.body.list;
							//console.log(this.pageInfo);
						},
						(resp) => {
							
						}
				);
			},
			
			//报废登记的方法
			scrapRegist: function(index){
				var bicycle_id = this.list[index].bicycle_id;
				var data = {
						bicycle_id:bicycle_id
				};
				var params={
						params:data
				}
				this.$http.get("scrap/register",params).then(
						(resp) => {
							var r = resp.bodyText;
							if(r == "success"){
								alert("报废登记成功")
								this.goPage(this.pageInfo.pageNum);	//刷新页面
							}else{
								alert(r);
							}
						},
						(resp) => {
							
						}
				
				);
			
			}
		}
	});
	
	vm.goPage(1); // 显示第1页数据