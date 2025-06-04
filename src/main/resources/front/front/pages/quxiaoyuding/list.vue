<template>
<!-- category 1 -->
<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback">
	<view class="content">
		<view :style='{"minHeight":"100vh","padding":"0","alignItems":"flex-start","flexWrap":"wrap","background":"linear-gradient(0deg, rgba(255,255,255,1) 80%, rgba(34,56,96,1) 98%, rgba(34,56,96,1) 100%),#fff","flexDirection":"column","display":"flex","width":"100%","position":"relative","height":"auto"}'>
			<view class="cu-bar bg-white search" :style='{"padding":"0px","margin":"0 auto","borderRadius":"16rpx","background":"none","display":"flex","width":"calc(100% - 48rpx)","height":"auto"}'>
				<picker v-if="queryList.length>1" mode="selector" :range="queryList" range-key="queryName" :value="queryIndex" @change="queryChange">
					<view :style='{"width":"40rpx","display":"none","height":"auto"}'>
						<text class="icon iconfont icon-jiantou18" :style='{"width":"40rpx","fontSize":"40rpx","lineHeight":"80rpx","color":"#666"}'></text>
					</view>
				</picker>
				<view :style='{"margin":"0","flex":"1","position":"relative"}' v-if="queryIndex==0" class="search-form round">
					<text class="icon iconfont icon-fangdajing01" :style='{"color":"#0060c8","borderRadius":"16rpx 0 0 16rpx","left":"0px","textAlign":"center","background":"#fff","width":"80rpx","fontSize":"40rpx","lineHeight":"80rpx","position":"absolute","right":"0px"}'></text>
					<input :style='{"border":"0","padding":"8rpx 20rpx 8rpx 80rpx","color":"#333","borderRadius":"16rpx 0 0 16rpx","background":"#fff","width":"100%","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}' v-model="searchForm.cheweibianhao" type="text" placeholder="车位编号" ></input>
				</view>
				<view :style='{"margin":"0","flex":"1","position":"relative"}' v-if="queryIndex==1" class="search-form round">
					<text class="icon iconfont icon-fangdajing01" :style='{"color":"#0060c8","borderRadius":"16rpx 0 0 16rpx","left":"0px","textAlign":"center","background":"#fff","width":"80rpx","fontSize":"40rpx","lineHeight":"80rpx","position":"absolute","right":"0px"}'></text>
					<input :style='{"border":"0","padding":"8rpx 20rpx 8rpx 80rpx","color":"#333","borderRadius":"16rpx 0 0 16rpx","background":"#fff","width":"100%","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}' v-model="searchForm.cheweimingcheng" type="text" placeholder="车位名称" ></input>
				</view>
				<button :style='{"border":"0","padding":"0px","margin":"0","color":"#fff","borderRadius":"0 16rpx 16rpx 0","background":"#ff6b5a","width":"136rpx","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}' @tap="search" class="cu-btn shadow-blur round">搜索</button>
			</view>
			

			
			<view :style='{"padding":"20rpx 0","margin":"260rpx 0 0 0","borderRadius":"60rpx 60rpx 0 0","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","lineHeight":"120rpx","position":"absolute","justifyContent":"center","order":"2","height":"120rpx"}'>
				<view @click="sortClick('addtime')" :style='{"border":"0","padding":"0 12rpx","margin":"0 8rpx 0 0","borderRadius":"8rpx","background":"none","display":"flex"}'>
					<text :style='{"color":"#333","lineHeight":"100rpx","fontSize":"28rpx"}'>按日期</text>
					<text v-if="listSort!='addtime'" class="icon iconfont icon-jiantou36" :style='{"margin":"0 4rpx 0 0","lineHeight":"100rpx","fontSize":"28rpx","color":"#333"}'></text>
					<text v-else-if="listSort=='addtime'&&listOrder=='asc'" class="icon iconfont icon-jiantou35" :style='{"margin":"0 4rpx 0 0","lineHeight":"100rpx","fontSize":"28rpx","color":"#333"}'></text>
					<text v-else-if="listSort=='addtime'&&listOrder=='desc'" class="icon iconfont icon-jiantou36" :style='{"margin":"0 4rpx 0 0","lineHeight":"100rpx","fontSize":"28rpx","color":"#333"}'></text>
				</view>
			</view>

			<view :style='{"alignItems":"flex-start","flexWrap":"wrap","background":"none","display":"flex","width":"100%","height":"auto","order":"10"}'>

			<!-- 样式2 -->
			<view class="list" :style='{"padding":"24rpx","margin":"136rpx 0 0","overflow":"hidden","background":"#fff","width":"100%","height":"auto","order":"50"}'>
				<view @tap="onDetailTap(product)" class="listm flex flex-between" :style='{"boxShadow":"0 0px 0px rgba(0,0,0,.3)","margin":"0 0 20rpx","alignItems":"center","flexWrap":"wrap","display":"flex","width":"100%","height":"auto"}' v-for="(product,index) in list" :key="index">
					<image :style='{"width":"200rpx","objectFit":"cover","borderRadius":"8rpx","display":"block","clipPath":"polygon(10% 0, 100% 0%, 90% 100%, 0% 100%)","height":"240rpx"}' mode="aspectFill" class="listmpic" v-if="preHttp(product.cheweitupian)" :src="product.cheweitupian.split(',')[0]"></image>
					<image :style='{"width":"200rpx","objectFit":"cover","borderRadius":"8rpx","display":"block","clipPath":"polygon(10% 0, 100% 0%, 90% 100%, 0% 100%)","height":"240rpx"}' mode="aspectFill" class="listmpic" v-else :src="product.cheweitupian?baseUrl+product.cheweitupian.split(',')[0]:''"></image>

					<view class="listmr" :style='{"width":"calc(100% - 200rpx)","padding":"12rpx 0 12rpx 20rpx","margin":"0","background":"linear-gradient(30deg, rgba(246,249,255,1) 0%, rgba(239,244,255,1) 100%),#f1f6ff","clipPath":"polygon(4% 0, 100% 0%, 96% 100%, 0% 100%)","height":"240rpx"}'>
						<view class="col3 f30 elip mb15" :style='{"width":"100%","padding":"0 20rpx","margin":"0","lineHeight":"48rpx","fontSize":"28rpx","color":"#333"}'>{{product.cheweimingcheng}}</view>
						<view :style='{"padding":"0 20rpx"}'>
							<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
							<text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.addtime}}</text>
						</view>
						<view :style='{"padding":"0 20rpx"}'>
							<text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
							<text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.zhanghao}}</text>
						</view>
					</view>

					<view :style='{"width":"100%","padding":"20rpx 20rpx","justifyContent":"space-between","display":"flex","height":"auto"}'>
						<view :style='{"display":"flex"}' v-if="(userid && isAuth('quxiaoyuding','修改')) || (!userid && isAuthFront('quxiaoyuding','修改'))" @tap.stop="onUpdateTap(product)">
							<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}' class="cuIcon-edit"></text>
							<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}'>修改</text>
						</view>
						<view :style='{"display":"flex"}' v-if="(userid && isAuth('quxiaoyuding','删除')) || (!userid && isAuthFront('quxiaoyuding','删除'))" @tap.stop="onDeleteTap(product.id)">
							<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}' class="cuIcon-delete"></text>
							<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}'>删除</text>
						</view>
					</view>
				</view>
			</view>
			
			
			

			

			</view>
			
			
			
		</view>

		<button :style='{"border":"0","boxShadow":"0 0px 4rpx rgba(0,0,0,.3)","color":"rgb(255, 255, 255)","bottom":"128rpx","right":"128rpx","borderRadius":"100%","background":"#ff6b5a","width":"80rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"absolute","height":"80rpx","zIndex":"999"}' v-if="userid && isAuth('quxiaoyuding','新增')" class="add-btn" @click="onAddTap()">新增</button>
		<button :style='{"border":"0","boxShadow":"0 0px 4rpx rgba(0,0,0,.3)","color":"rgb(255, 255, 255)","bottom":"128rpx","right":"128rpx","borderRadius":"100%","background":"#ff6b5a","width":"80rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"absolute","height":"80rpx","zIndex":"999"}' v-if="!userid && isAuthFront('quxiaoyuding','新增')" class="add-btn" @click="onAddTap()">新增</button>
	</view>
</mescroll-uni>
</template>

<script>
	export default {
		data() {
			return {
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				queryList:[
					{
						queryName:"车位编号",
					},
					{
						queryName:"车位名称",
					},
				],
				queryIndex: 0,
				list: [],
				lists: [],
                userid: '',
				mescroll: null, //mescroll实例对象
				downOption: {
					auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
				},
				upOption: {
					noMoreSize: 5, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
					textNoMore: '~ 没有更多了 ~',
				},
				hasNext: true,
				searchForm:{},
				CustomBar: '0',
				listSort: 'id',
				listOrder: 'desc',
			};
		},
		watch: {
		},
		mounted() {
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
		},
		async onShow() {
			this.btnColor = this.btnColor.sort(()=> {
				return (0.5-Math.random());
			});
			this.hasNext = true
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
		},
		onLoad(options) {
            if(options.userid) {
                this.userid=options.userid;
            } else {
                this.userid = "";
            }
			this.hasNext = true
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
		},
		methods: {
			uGetRect(selector, all) {
				return new Promise(resolve => {
					uni.createSelectorQuery()
					.in(this)
					[all ? 'selectAll' : 'select'](selector)
					.boundingClientRect(rect => {
						if (all && Array.isArray(rect) && rect.length) {
							resolve(rect);
						}
						if (!all && rect) {
							resolve(rect);
						}
					})
					.exec();
				});
			},
			cloneData(data) {
				return JSON.parse(JSON.stringify(data));
			},
			sortClick(type){
				if(this.listSort==type){
					if(this.listOrder == 'desc'){
						this.listOrder = 'asc'
					}else{
						this.listOrder = 'desc'
					}
				}else{
					this.listSort = type
					this.listOrder = 'desc'
				}
				this.search()
			},
            priceChange(price) {
                return Number(price).toFixed(2);
            },
            preHttp(str) {
                return str && str.substr(0,4)=='http';
            },
			//查询条件切换
			queryChange(e) {
				this.queryIndex=e.detail.value;
				this.searchForm.cheweibianhao="";
				this.searchForm.cheweimingcheng="";
			},
			//类别搜索
			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},
			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				// 重置分页参数页数为1
				mescroll.resetUpScroll()
			},
			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
				let params = {
					page: mescroll.num,
					limit: mescroll.size
				}
				params['sort'] = this.listSort;
				params['order'] = this.listOrder;

				if(this.searchForm.cheweibianhao){
					params['cheweibianhao'] = '%' + this.searchForm.cheweibianhao + '%'
				}
				if(this.searchForm.cheweimingcheng){
					params['cheweimingcheng'] = '%' + this.searchForm.cheweimingcheng + '%'
				}



                let res = {}
                if(this.userid) {
                    res = await this.$api.page(`quxiaoyuding`, params);
                } else {
                    res = await this.$api.list(`quxiaoyuding`, params);
                }
				// 如果是第一页数据置空
				if (mescroll.num == 1) this.list = [];
				
				this.list = this.list.concat(res.data.list);
				let length = Math.ceil(this.list.length/6)
				let arr = [];
				for (let i = 0; i<length; i++){
					arr[i] = this.list.slice(i*6, (i+1)*6)
				}
				this.lists = arr
				if (res.data.list.length == 0) this.hasNext = false;
				mescroll.endSuccess(mescroll.size, this.hasNext);
				
			},
			// 详情
			onDetailTap(item) {
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./detail?id=${item.id}&userid=`+this.userid)
			},
			// 修改
			onUpdateTap(row){
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./add-or-update?id=${row.id}`)
			},
			// 添加
			onAddTap(){
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./add-or-update`)
			},
			onDeleteTap(id){
				var _this = this;
				uni.showModal({
					title: '提示',
					content: '是否确认删除',
					success: async function(res) {
						if (res.confirm) {
							await _this.$api.del('quxiaoyuding', JSON.stringify([id]));
							_this.hasNext = true
							// 重置分页参数页数为1
							_this.search()
						}
					}
				});
			},
			// 搜索
			async search(){
				this.mescroll.num = 1
				let searchForm = {
					page: this.mescroll.num,
					limit: this.mescroll.size
				}
				searchForm['sort'] = this.listSort;
				searchForm['order'] = this.listOrder;

				if(this.searchForm.cheweibianhao){
					searchForm['cheweibianhao'] = '%' + this.searchForm.cheweibianhao + '%'
				}
				if(this.searchForm.cheweimingcheng){
					searchForm['cheweimingcheng'] = '%' + this.searchForm.cheweimingcheng + '%'
				}
                let res = {};
                if(this.userid) {
                    res = await this.$api.page(`quxiaoyuding`, searchForm);
                } else {
                    res = await this.$api.list(`quxiaoyuding`, searchForm);
                }
				// 如果是第一页数据置空
				if (this.mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				let length = Math.ceil(this.list.length/6)
				let arr = [];
				for (let i = 0; i<length; i++){
					arr[i] = this.list.slice(i*6, (i+1)*6)
				}
				this.lists = arr
				if (res.data.list.length == 0) this.hasNext = false;
				this.mescroll.endSuccess(this.mescroll.size, this.hasNext);
			}
		}
	};
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	
	.category-one .tab {
		cursor: pointer;
		padding: 0 20rpx;
		margin: 0 10rpx;
		color: #333;
		display: inline-block;
		font-size: 28rpx;
		line-height: 96rpx;
		border-radius: 12rpx;
		clip-path: polygon(8% 0, 92% 0, 100% 100%, 0% 100%);
		background: #ffffff;
		width: auto;
		text-align: center;
		min-width: 120rpx;
	}
	
	.category-one .tab.active {
		cursor: pointer;
		padding: 0 20rpx;
		margin: 0 10rpx;
		color: #fff;
		display: inline-block;
		font-size: 28rpx;
		line-height: 96rpx;
		border-radius: 12rpx;
		clip-path: polygon(8% 0, 92% 0, 100% 100%, 0% 100%);
		background: #ff6b5a;
		width: auto;
		text-align: center;
		min-width: 120rpx;
	}
	
	.category-two .tab {
		cursor: pointer;
		border-radius: 16rpx 0 0 0;
		padding: 0;
		color: #333;
		background: none;
		display: inline-block;
		width: 100%;
		font-size: 28rpx;
		line-height: 80rpx;
		text-align: center;
	}
	
	.category-two .tab.active {
		cursor: pointer;
		border-radius: 16rpx 0 0 0;
		padding: 0;
		color: #fff;
		background: #a5ccc4;
		display: inline-block;
		width: 100%;
		font-size: 28rpx;
		line-height: 80rpx;
		text-align: center;
	}
	
	.category-three .tab {
		cursor: pointer;
		padding: 0;
		color: #fff;
		background: burlywood;
		display: inline-block;
		width: 100%;
		font-size: 28rpx;
		line-height: 80rpx;
		text-align: center;
	}
	
	.category-three .tab.active {
		cursor: pointer;
		padding: 0;
		color: #fff;
		background: #000;
		display: inline-block;
		width: 100%;
		font-size: 28rpx;
		line-height: 80rpx;
		text-align: center;
	}
</style>
