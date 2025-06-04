<template>
<view class="content">
	<view :style='{"minHeight":"100vh","padding":"0px","overflow":"hidden","alignItems":"flex-start","flexWrap":"wrap","background":"linear-gradient(0deg, rgba(255,255,255,1) 96%, rgba(34,56,96,1) 98%, rgba(34,56,96,1) 100%),#fff","flexDirection":"row","display":"flex","width":"100%","height":"auto"}'>
		<view class="list-swiper-4" :style='{"width":"100%","margin":"0 auto","position":"relative","borderRadius":"60rpx 60rpx 0 0","background":"#fff","height":"360rpx"}' @touchstart="touchStart" @touchmove="touchMove" @touchend="touchEnd">
			<view :style='{"overflow":"hidden","top":"40rpx","borderRadius":"40rpx","left":"24rpx","background":"#fff","width":"calc(100% - 48rpx)","position":"absolute","height":"320rpx"}' class="item animate__animated" :class="prevNumList4 == index  ? 'animate__backOutRight' : (numList4 == index  ? 'animate__backInLeft' : '')" v-for="(swiper,index) in swiperList" :key="index" v-if="numList4 == index || prevNumList4 == index">
				<image :style='{"width":"100%","objectFit":"cover","borderRadius":"40rpx","display":"block","height":"320rpx"}' mode="aspectFill" :src="baseUrl+swiper.img"></image>
				<view :style='{"padding":"8rpx 20rpx 80rpx","margin":"-20rpx 0 0 0","color":"#fff","textAlign":"center","display":"none","transform":"translate3d(-50%, -50%, 0)","top":"100%","left":"50%","background":"rgba(255, 255, 255, 0.0)","width":"100%","lineHeight":"1.5","fontSize":"28rpx","position":"absolute"}'>{{ swiper.title }}</view>
			</view>
			<view class="animate__navigation" :style='{"alignItems":"center","left":"0%","bottom":"0%","background":"rgba(0,0,0,.0)","display":"none","width":"100%","position":"absolute","justifyContent":"center","height":"40rpx"}'>
				<block v-for="(swiper,index) in swiperList" :key="index">
					<text class="navigation-item" v-if="numList4 == index" :style='{"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#a5ccc4","height":"16rpx"}'></text>
					<text class="navigation-item" v-if="numList4 != index" :style='{"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#fff","height":"16rpx"}'></text>
				</block>
			</view>
		</view>

		<view class="cu-bar bg-white search" :style='{"padding":"0px","margin":"0 auto 40rpx","borderRadius":"16rpx","background":"none","display":"flex","width":"calc(100% - 48rpx)","height":"auto","order":"-1"}'>
			<picker :style='{"width":"40rpx","lineHeight":"80rpx","position":"relative","alignItems":"center","justifyContent":"center","display":"none"}' v-if="queryList.length>1" mode="selector" :range="queryList" range-key="queryName" :value="queryIndex" @change="queryChange">
				<text class="icon iconfont icon-jiantou18" :style='{"width":"40rpx","lineHeight":"80rpx","position":"absolute","color":"rgb(153, 153, 153)","textAlign":"center"}'></text>
			</picker>
			<view :style='{"margin":"0","flex":"1","position":"relative"}' v-if="queryIndex==0" class="search-form round">
				<text class="icon iconfont icon-fangdajing01" :style='{"color":"#0060c8","borderRadius":"16rpx 0 0 16rpx","left":"0px","textAlign":"center","width":"80rpx","fontSize":"40rpx","lineHeight":"80rpx","position":"absolute","right":"0px"}'></text>
				<input :style='{"border":"0","padding":"12rpx 20rpx 12rpx 80rpx","color":"#333","borderRadius":"16rpx 0 0 16rpx","background":"#fff","width":"100%","lineHeight":"56rpx","fontSize":"28rpx","height":"80rpx"}' v-model="searchForm.cheweixinxicheweizhuangtai" type="text" placeholder="车位状态" ></input>
			</view>
			<button :style='{"border":"0","padding":"0px","margin":"0","color":"#fff","borderRadius":"0 16rpx 16rpx 0","background":"#ff6b5a","width":"136rpx","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}' v-if="queryIndex==0" @tap="onPageTap('cheweixinxi')" class="cu-btn shadow-blur round">搜索</button>
		</view>

		<!-- menu -->
        <view style="width: 100%" v-if="swiperMenuList.length">
            <swiper :style='{"padding":"40rpx 0 160rpx 0","margin":"0","borderRadius":"0px","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20231207/c5343ec705724f408a4ad3318a1ff8e4.jpg) no-repeat center bottom / 100% auto,#ffffff","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}' class="swiper">
                <swiper-item v-for="(swiper,index) in (new Array(Number(Math.ceil(swiperMenuList.length / (rows * column)))).fill('').map((val, i) => i+1))" :key="index">
                    <view v-for="(row, index1) in (new Array(Number(rows)).fill('').map((val, i) => i+1))" :key="index1" style="display: flex;flex-wrap: wrap;">
                        <view v-for="(col, index2) in (new Array(Number(column)).fill('').map((val, i) => i+1))" :key="index2" v-if="(((row+rows*(swiper-1) -1)*column + col -1)<swiperMenuList.length)" :style='{"width":"25%","padding":"12rpx 0","margin":"10rpx 0","height":"auto"}' class="menu-list">
                            <view :class="swiperMenuList[(row+rows*(swiper-1) -1)*column + col -1].child[0].appFrontIcon" @tap="onPageTap2('../'+swiperMenuList[(row+rows*(swiper-1) -1)*column + col -1].child[0].tableName+'/list')" :style='{"padding":"0","margin":"0px auto","color":"#fff","borderRadius":"12rpx","textAlign":"center","background":"linear-gradient(180deg, rgba(153,186,246,1) 0%, rgba(99,148,254,1) 100%)","display":"block","clipPath":"polygon(8% 0, 92% 0, 100% 100%, 0% 100%)","width":"96rpx","lineHeight":"96rpx","fontSize":"64rpx","height":"96rpx"}'>
                            </view>
                            <view :style='{"padding":"0","margin":"12rpx auto 0","color":"#333","textAlign":"center","width":"100%","lineHeight":"28rpx","fontSize":"28rpx"}'>{{swiperMenuList[(row+rows*(swiper-1) -1)*column + col -1].child[0].menu.split("列表")[0]}} </view>
                        </view>
                    </view>
                </swiper-item>
            </swiper>
        </view>
		<!-- menu -->
		

		
		<!-- 商品推荐 -->
		<!-- 商品推荐 -->
		
		<!-- 商品列表 -->
		<view class="listBox list" :style='{"width":"100%","margin":"40rpx auto 0","background":"none","order":"3"}'>
			<view class="title" :style='{"padding":"0 24rpx","margin":"0","textAlign":"center","background":"url(http://codegen.caihongy.cn/20231208/dd4367eb2136483aa23e9dc12954f2df.png) no-repeat center top","display":"block","width":"100%","lineHeight":"100rpx","position":"relative","justifyContent":"space-between","height":"96rpx"}'>
				<view :style='{"color":"#223860","fontSize":"32rpx","fontWeight":"600"}'>停车场</view>
				<view :style='{"position":"absolute","right":"80rpx","top":"-40rpx","display":"block"}' @tap="onPageTap('tingchechang')">
				  <text :style='{"color":"#999","fontSize":"28rpx"}'>更多</text>
				  <text class="icon iconfont icon-gengduo1" :style='{"color":"#999","fontSize":"28rpx"}'></text>
				</view>
			</view>
		  
		  
		  <!-- 样式3 -->
		  <view v-if="3 == 3" class="list-box style3" :style='{"width":"100%","padding":"24rpx 24rpx 0","margin":"20rpx 0 0","height":"auto"}'>
			<view @tap="onDetailTap('tingchechang',product.id)" v-for="(product,index) in hometingchechanglist" :key="index" class="list-item" :style='{"boxShadow":"0 0px 0px rgba(0,0,0,.3)","margin":"0 0 40rpx","alignItems":"center","flexWrap":"wrap","display":"flex","width":"100%","height":"auto"}'>
			  <image :style='{"width":"200rpx","objectFit":"cover","borderRadius":"8rpx","display":"block","clipPath":"polygon(10% 0, 100% 0%, 90% 100%, 0% 100%)","height":"240rpx"}' class="list-item-image" mode="aspectFill" v-if="product.tupian.substring(0,4)=='http'" :src="product.tupian"></image>
			  <image :style='{"width":"200rpx","objectFit":"cover","borderRadius":"8rpx","display":"block","clipPath":"polygon(10% 0, 100% 0%, 90% 100%, 0% 100%)","height":"240rpx"}' class="list-item-image" mode="aspectFill" v-else :src="product.tupian?baseUrl+product.tupian.split(',')[0]:''"></image>
			  <view class="list-item-body" :style='{"width":"calc(100% - 200rpx)","padding":"12rpx 0 12rpx 20rpx","margin":"0","background":"linear-gradient(30deg, rgba(246,249,255,1) 0%, rgba(239,244,255,1) 100%),#f1f6ff","clipPath":"polygon(4% 0, 100% 0%, 96% 100%, 0% 100%)","height":"240rpx"}'>
				<view :style='{"width":"100%","padding":"0 20rpx","margin":"0","lineHeight":"48rpx","fontSize":"28rpx","color":"#333"}' class="list-item-title">{{product.tingchechang}}</view>
				<view :style='{"width":"100%","padding":"0 20rpx","margin":"0","lineHeight":"48rpx","fontSize":"28rpx","color":"#333"}' class="list-item-title">{{product.cheweizongshu}}</view>
				<view :style='{"padding":"0 20rpx"}'>
				  <text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
				  <text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.addtime}}</text>
				</view>
			  </view>
			</view>
		  </view>
		  
		  
		  
		  
		  
		  

		</view>
		<view class="listBox list" :style='{"width":"100%","margin":"40rpx auto 0","background":"none","order":"3"}'>
			<view class="title" :style='{"padding":"0 24rpx","margin":"0","textAlign":"center","background":"url(http://codegen.caihongy.cn/20231208/dd4367eb2136483aa23e9dc12954f2df.png) no-repeat center top","display":"block","width":"100%","lineHeight":"100rpx","position":"relative","justifyContent":"space-between","height":"96rpx"}'>
				<view :style='{"color":"#223860","fontSize":"32rpx","fontWeight":"600"}'>车位信息</view>
				<view :style='{"position":"absolute","right":"80rpx","top":"-40rpx","display":"block"}' @tap="onPageTap('cheweixinxi')">
				  <text :style='{"color":"#999","fontSize":"28rpx"}'>更多</text>
				  <text class="icon iconfont icon-gengduo1" :style='{"color":"#999","fontSize":"28rpx"}'></text>
				</view>
			</view>
		  
		  
		  <!-- 样式3 -->
		  <view v-if="3 == 3" class="list-box style3" :style='{"width":"100%","padding":"24rpx 24rpx 0","margin":"20rpx 0 0","height":"auto"}'>
			<view @tap="onDetailTap('cheweixinxi',product.id)" v-for="(product,index) in homecheweixinxilist" :key="index" class="list-item" :style='{"boxShadow":"0 0px 0px rgba(0,0,0,.3)","margin":"0 0 40rpx","alignItems":"center","flexWrap":"wrap","display":"flex","width":"100%","height":"auto"}'>
			  <image :style='{"width":"200rpx","objectFit":"cover","borderRadius":"8rpx","display":"block","clipPath":"polygon(10% 0, 100% 0%, 90% 100%, 0% 100%)","height":"240rpx"}' class="list-item-image" mode="aspectFill" v-if="product.cheweitupian.substring(0,4)=='http'" :src="product.cheweitupian"></image>
			  <image :style='{"width":"200rpx","objectFit":"cover","borderRadius":"8rpx","display":"block","clipPath":"polygon(10% 0, 100% 0%, 90% 100%, 0% 100%)","height":"240rpx"}' class="list-item-image" mode="aspectFill" v-else :src="product.cheweitupian?baseUrl+product.cheweitupian.split(',')[0]:''"></image>
			  <view class="list-item-body" :style='{"width":"calc(100% - 200rpx)","padding":"12rpx 0 12rpx 20rpx","margin":"0","background":"linear-gradient(30deg, rgba(246,249,255,1) 0%, rgba(239,244,255,1) 100%),#f1f6ff","clipPath":"polygon(4% 0, 100% 0%, 96% 100%, 0% 100%)","height":"240rpx"}'>
				<view :style='{"width":"100%","padding":"0 20rpx","margin":"0","lineHeight":"48rpx","fontSize":"28rpx","color":"#333"}' class="list-item-title">{{product.cheweimingcheng}}</view>
				<view :style='{"padding":"0 20rpx"}'>
				  <text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
				  <text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.addtime}}</text>
				</view>
				<view :style='{"padding":"0 20rpx","display":"inline-block"}'>
				  <text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
				  <text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.storeupnum}}</text>
				</view>
			  </view>
			</view>
		  </view>
		  
		  
		  
		  
		  
		  

		</view>
		<!-- 商品列表 -->
		
		<!-- 新闻资讯 -->
		<view class="listBox news" :style='{"width":"100%","margin":"60rpx 0 0","background":"none","order":"1"}'>
			<view class="title" :style='{"padding":"0 24rpx","margin":"40rpx auto","textAlign":"center","background":"url(http://codegen.caihongy.cn/20231208/dd4367eb2136483aa23e9dc12954f2df.png) no-repeat center top","display":"block","width":"100%","lineHeight":"100rpx","position":"relative","justifyContent":"space-between","height":"96rpx"}'>
				<view :style='{"color":"#223860","fontSize":"32rpx","fontWeight":"600"}'>通知公告</view>
				<view :style='{"position":"absolute","right":"84rpx","alignItems":"center","top":"-40rpx","justifyContent":"center","display":"flex"}' @tap="onPageTap('news')">
				  <text :style='{"color":"#999","fontSize":"28rpx"}'>更多</text>
				  <text class="icon iconfont icon-gengduo1" :style='{"color":"#999","fontSize":"28rpx"}'></text>
				</view>
			</view>
		  
			<!-- 样式2 -->
			<view class="list-box style2" :style='{"width":"100%","padding":"24rpx 24rpx 0","height":"auto"}'>
			  <view class="tabView" :style='{"width":"100%","flexWrap":"wrap","justifyContent":"center","display":"flex"}'>
			    <view class="tab" :class="newsIndex2==index?'tabActive':''" v-for="(item,index) in newsCateList2" :key="index" @click="newsTabClick2(index)">
			      <text class="icon iconfont icon-zhangjie7" :style='{"margin":"0 4rpx 0 0","lineHeight":"68rpx","fontSize":"28rpx","color":"inherit"}'></text>
			      <text :style='{"color":"inherit","lineHeight":"68rpx","fontSize":"28rpx"}'>{{item.typename}}</text>
			    </view>
			  </view>
			  <view :style='{"width":"100%","margin":"32rpx 0 0","background":"#fff"}'>
			    <view @tap="onNewsDetailTap(item.id)" v-for="(item,index) in news" :key="index" class="list-item" :style='{"padding":"0px","borderColor":"#13b400","margin":"0 0 40rpx","borderRadius":"0px","flexWrap":"wrap","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"dashed"}'>
			      <view :style='{"alignItems":"center","color":"#fff","borderRadius":"8rpx","background":"linear-gradient(45deg, rgba(75,100,145,1) 0%, rgba(43,70,117,1) 48%, rgba(49,76,126,1) 100%),#223860","flexDirection":"column","display":"flex","clipPath":"polygon(10% 0, 100% 0%, 90% 100%, 0% 100%)","width":"176rpx","fontSize":"28rpx","justifyContent":"center"}'>
			        <view :style='{"color":"#c2d6fa","fontSize":"28rpx","lineHeight":"1.5"}'>{{item.addtime.split(" ")[0].split("-")[2]}}</view>
			        <view :style='{"color":"#c2d6fa","fontSize":"28rpx","lineHeight":"1.5"}'>{{item.addtime.split(" ")[0].split("-")[0]}}-{{item.addtime.split(" ")[0].split("-")[1]}}</view>
			      </view>
			      <view class="list-item-body" :style='{"width":"calc(100% - 176rpx)","padding":"8rpx 0 8rpx 20rpx","background":"linear-gradient(30deg, rgba(246,249,255,1) 0%, rgba(239,244,255,1) 100%),#f1f6ff","clipPath":"polygon(4% 0, 100% 0%, 96% 100%, 0% 100%)"}'>
			        <view :style='{"padding":"0 20rpx","margin":"0","overflow":"hidden","whiteSpace":"hidden","color":"#333","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","textOverflow":"ellipsis"}' class="title">{{item.title}}</view>
			        <view :style='{"padding":"0 20rpx","overflow":"hidden","whiteSpace":"nowrap","color":"#8e8d8c","width":"100%","lineHeight":"1.5","fontSize":"28rpx","textOverflow":"ellipsis"}' class="text">{{item.introduction}}</view>
			        <view :style='{"padding":"0 20rpx"}'>
			          <text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
			          <text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.name}}</text>
			        </view>
			        <view :style='{"padding":"0 20rpx","display":"inline-block"}'>
			          <text class="icon iconfont icon-zan19" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
			          <text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.thumbsupnum}}</text>
			        </view>
			        <view :style='{"padding":"0 20rpx","display":"inline-block"}'>
			          <text class="icon iconfont icon-cai01" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
			          <text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.storeupnum}}</text>
			        </view>
			        <view :style='{"padding":"0 20rpx","display":"inline-block"}'>
			          <text class="icon iconfont icon-chakan12" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
			          <text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.clicknum}}</text>
			        </view>
			      </view>
			    </view>
			  </view>
			</view>
			
			
		  <!-- 样式4 -->
		  
		  <!-- 样式5 -->
		  
		  <!-- 样式6 -->
		  
		  <!-- 样式7 -->
		  
		  <!-- 样式8 -->
		  
		  <!-- 样式9 -->

		</view>
		<!-- 新闻资讯 -->

	</view>
</view>
</template>

<script>
    import menu from '@/utils/menu'
	import '@/assets/css/global-restaurant.css'
	import uniIcons from "@/components/uni-ui/lib/uni-icons/uni-icons.vue"
	export default {
		components: {
			uniIcons
		},
		data() {
			return {
				startX: 0,
				prevNumList4: '',
				numList4: 0,
				timerList4: null,
				flagList4: false,
				navigationActive: {"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#a5ccc4","height":"16rpx"},
				navigationDefault: {"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#fff","height":"16rpx"},
				options2: {
					effect: 'flip',
					loop : true
				},
				options3: {
					effect: 'cube',
					loop : true,
					cubeEffect: {
						shadow: true,
						slideShadows: true,
						shadowOffset: 20,
						shadowScale: 0.94,
					}
				},
				rows: 2,
				column: 4,
				iconArr: [
				  'cuIcon-same',
				  'cuIcon-deliver',
				  'cuIcon-evaluate',
				  'cuIcon-shop',
				  'cuIcon-ticket',
				  'cuIcon-cascades',
				  'cuIcon-discover',
				  'cuIcon-question',
				  'cuIcon-pic',
				  'cuIcon-filter',
				  'cuIcon-footprint',
				  'cuIcon-pulldown',
				  'cuIcon-pullup',
				  'cuIcon-moreandroid',
				  'cuIcon-refund',
				  'cuIcon-qrcode',
				  'cuIcon-remind',
				  'cuIcon-profile',
				  'cuIcon-home',
				  'cuIcon-message',
				  'cuIcon-link',
				  'cuIcon-lock',
				  'cuIcon-unlock',
				  'cuIcon-vip',
				  'cuIcon-weibo',
				  'cuIcon-activity',
				  'cuIcon-friendadd',
				  'cuIcon-friendfamous',
				  'cuIcon-friend',
				  'cuIcon-goods',
				  'cuIcon-selection'
				],
                role : '',
                menuList: [],
                swiperMenuList:[],
                user: {},
                tableName:'',
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				queryList:[
					{
						queryName:"车位状态",
					},
				],
				queryIndex: 0,
				searchForm:{
					cheweixinxicheweizhuangtai:'',
				},
				CustomBar: '0',

				//轮播
				swiperList: [],
				hometingchechanglist: [],
				homecheweixinxilist: [],
				news: [],
				newsCateList2: [],
				newsIndex2: 0,

















































			}
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
        async onLoad(){
            this.role = uni.getStorageSync("role");
            let table = uni.getStorageSync("nowTable");
            let res = await this.$api.session(table);
            this.user = res.data;
            this.tableName = table;
            let menus = menu.list();
            this.menuList = menus;
            this.menuList.forEach((item,key) => {
                if(key==0) {
                    item.frontMenu.forEach((item2,key2) => {
                        if(item2.child[0].buttons.indexOf("查看")>-1) {
                            this.swiperMenuList.push(item2);
                        }
                    })
                }
            })
        },
		async onShow() {
            this.btnColor = this.btnColor.sort(()=> {
                    return (0.5-Math.random());
            });
            let res;
			// 轮播图
			let swiperList = []
			res = await this.$api.list('config', {
				page: 1,
				limit: 5
			});
			for (let item of res.data.list) {
				if (item.name.indexOf('picture') >= 0 && item.value && item.value!="" && item.value!=null ) {
					swiperList.push({
						img: item.value,
                        title: item.name,
						url: item.url
					});
				}
			}
			if (swiperList) {
				this.swiperList = swiperList;
			}
			
			this.prevNumList4 = this.swiperList.length - 1
			this.timerList4 = setInterval(this.autoPlayList4, 6000)

			if(uni.getStorageSync("appUserid")) {
			    res = await this.$api.page('newstype', {page:1,limit:100});
			} else {
			    res = await this.$api.list('newstype', {page:1,limit:100});
			}
			res.data.list.splice(0,0,{id:0,typename:'全部'})
			this.newsIndex2 = 0
			this.newsCateList2 = res.data.list
			this.getRecommendList()
			this.getHomeList()
			this.getNewsList()
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
			newsTabClick2(index){
				this.newsIndex2 = index
				this.getNewsList()
			},
			async getNewsList(){
				let res;
				let params = {
					page: 1,
					limit: 6,
					sort: 'id',
					order: 'desc',
				}
				if(this.newsIndex2){
					params.typename = this.newsCateList2[this.newsIndex2].typename
				}
				// 通知公告
				res = await this.$api.list('news', params)
				this.news = res.data.list
				
				
			},
			homeTabClick2(index,name){
				this['home' + name + 'Index2'] = index
				this.getHomeList()
			},
			async getHomeList(){
				let res;
				let params;
				params = {
					page:1,
					limit: 8,
				}
				res = await this.$api.list('tingchechang', params);
				this.hometingchechanglist = res.data.list
				

				params = {
					page:1,
					limit: 8,
				}
				res = await this.$api.list('cheweixinxi', params);
				this.homecheweixinxilist = res.data.list
				

			},
			recommendTabClick2(index,name){
				this[name + 'Index2'] = index
				this.getRecommendList()
			},
			async getRecommendList(){
				let res;
				let params;
			},
			autoPlayList4() {
				this.prevNumList4 = this.numList4
			
				this.numList4++
				if (this.numList4 == this.swiperList.length) this.numList4 = 0
			},
			touchStart(event) {
				this.startX = event.touches[0].clientX
				
				clearInterval(this.timerList4)
				this.flagList4 = true
			},
			touchMove(event) {
				const currentX = event.touches[0].clientX;
				const deltaX = currentX - this.startX;
				
				if (deltaX > 50) {
					// 向右滑动逻辑
					if (this.flagList4) {
						this.flagList4 = false
						
						this.prevNumList4 = this.numList4
						this.numList4++
						if (this.numList4 == this.swiperList.length) this.numList4 = 0
					}
					
				} else if (deltaX < -50) {
					// 向左滑动逻辑
					if (this.flagList4) {
						this.flagList4 = false
						
						this.prevNumList4 = this.numList4
						this.numList4--
						if (this.numList4 < 0) this.numList4 = this.swiperList.length - 1
					}
				}
			},
			touchEnd() {
				this.startX = 0
				
				this.timerList4 = setInterval(this.autoPlayList4, 6000)
				this.flagList4 = false
			},
			//查询条件切换
			queryChange(e) {
				this.queryIndex=e.detail.value;
				this.searchForm.cheweixinxicheweizhuangtai="";
			},
			//轮播图跳转
			onSwiperTap(e) {
				if(e.url) {
					if (e.url.indexOf('https') != -1) {
						window.open(e.url)
					} else {
						this.$utils.jump(e.url)
					}
				}
			},
			// 新闻详情
			onNewsDetailTap(id) {
				this.$utils.jump(`../news-detail/news-detail?id=${id}`)
			},
			// 推荐列表点击详情
			onDetailTap(tableName, id) {
				this.$utils.jump(`../${tableName}/detail?id=${id}`)
			},
			onPageTap(tableName){
				if(this.queryIndex==0) {
					uni.setStorageSync('indexQueryCondition',this.searchForm.cheweixinxicheweizhuangtai);
					this.searchForm.cheweixinxicheweizhuangtai = '';
				}

				uni.navigateTo({
					url: `../${tableName}/list`,
					fail: function(){
						uni.switchTab({
							url: `../${tableName}/list`
						});
					}
				});
				// this.$utils.jump(`../${tableName}/list`)
			},
            onPageTap2(url) {
                uni.setStorageSync("useridTag",0);
                uni.navigateTo({
                    url: url,
                    fail: function() {
                        uni.switchTab({
                            url: url
                        });
                    }
                });
            }
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	.list-swiper-4 .animate__animated {
		--animate-delay: 300ms;
	}

	.news {
		.style2 {
			.tabView {
				.tab {
					border: 2rpx solid #22386080;
					border-radius: 40rpx;
					padding: 0 30rpx;
					margin: 0 10rpx 20rpx;
					color: #223860;
					background: #fff;
				}
				.tabActive {
					border: 2rpx solid #223860;
					border-radius: 40rpx;
					padding: 0 20rpx;
					margin: 0 10rpx 20rpx;
					color: #fff;
					background: #223860;
				}
			}
		}
	}
</style>
