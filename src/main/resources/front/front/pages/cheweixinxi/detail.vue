
<template>
<view>
<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback">
	<view class="content">
		<view class="container" :style='{"minHeight":"100vh","width":"100%","padding":"0px","position":"relative","background":"linear-gradient(0deg, rgba(255,255,255,1) 90%, rgba(34,56,96,1) 95%, rgba(34,56,96,1) 100%),#fff","height":"auto"}'>
															<view class="list-swiper-4" :style='{"width":"100%","position":"relative","height":"360rpx"}' @touchstart="touchStart" @touchmove="touchMove" @touchend="touchEnd">
				<view :style='{"width":"100%","position":"absolute","top":"0%","left":"0%","background":"#fff","height":"360rpx"}' class="item animate__animated" :class="prevNumList4 == index  ? 'animate__backOutRight' : (numList4 == index  ? 'animate__backOutRight' : '')" v-for="(swiper,index) in swiperList" :key="index" v-if="numList4 == index || prevNumList4 == index">
					<image :style='{"width":"100%","objectFit":"contain","background":"#f1f6ff","display":"block","height":"360rpx"}' mode="aspectFill" v-if="swiper.substring(0,4)=='http'" :src="swiper"></image>
					<image :style='{"width":"100%","objectFit":"contain","background":"#f1f6ff","display":"block","height":"360rpx"}' mode="aspectFill" v-else :src="baseUrl+swiper"></image>
					<view :style='{"padding":"8rpx 20rpx","margin":"-20rpx 0 0 0","transform":"translate3d(-50%, -50%, 0)","top":"50%","color":"#000","left":"50%","background":"rgba(255, 255, 255, 0.3)","display":"none","lineHeight":"1.5","fontSize":"40rpx","position":"absolute"}'>标题</view>
				</view>
				<view class="animate__navigation" :style='{"alignItems":"center","left":"0%","bottom":"0%","background":"rgba(0,0,0,.0)","display":"flex","width":"100%","position":"absolute","justifyContent":"center","height":"60rpx"}'>
					<block v-for="(swiper,index) in swiperList" :key="index">
						<text class="navigation-item" v-if="numList4 == index" :style='{"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#22386080","height":"16rpx"}'></text>
						<text class="navigation-item" v-if="numList4 != index" :style='{"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#fff","height":"16rpx"}'></text>
					</block>
				</view>
			</view>
			            <view :style='{"padding":"0 24rpx","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}' class="detail-content">
				<view :style='{"width":"auto","padding":"0 20rpx","float":"right","textAlign":"right"}' v-if="storeupFlag==1" @click="shoucang">
					<text class="icon iconfont icon-shoucang04" :style='{"margin":"0 4rpx 0 0","lineHeight":"80rpx","fontSize":"36rpx","color":"#f15b12"}'></text>
					<text :style='{"color":"#f15b12","lineHeight":"80rpx","fontSize":"28rpx"}'>收藏</text>
				</view>
				<view :style='{"width":"auto","padding":"0 20rpx","float":"right","textAlign":"right"}' v-if="storeupFlag==0" @click="shoucang">
					<text class="icon iconfont icon-shoucang04" :style='{"margin":"0 4rpx 0 0","lineHeight":"80rpx","fontSize":"36rpx","color":"#f15b12"}'></text>
					<text :style='{"color":"#f15b12","lineHeight":"80rpx","fontSize":"28rpx"}'>收藏</text>
				</view>

				<view :style='{"padding":"8rpx 3%","margin":"0 0 12rpx 0","borderColor":"#d8d8d8","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"1"}' class="detail-list-item title">
					<view :style='{"padding":"0 20rpx 0 0","color":"#223860","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"500"}' class="lable">车位名称：</view>
					<view :style='{"padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"#666"}' class="text">{{detail.cheweimingcheng}}</view>
				</view>

				<view class="detail-list-item" :style='{"padding":"8rpx 3%","margin":"0 0 12rpx 0","borderColor":"#d8d8d8","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"1"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#223860","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"500"}'>停车场：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"#666"}'>{{detail.tingchechang}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"8rpx 3%","margin":"0 0 12rpx 0","borderColor":"#d8d8d8","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"1"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#223860","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"500"}'>车位编号：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"#666"}'>{{detail.cheweibianhao}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"8rpx 3%","margin":"0 0 12rpx 0","borderColor":"#d8d8d8","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"1"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#223860","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"500"}'>车位位置：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"#666"}'>{{detail.cheweiweizhi}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"8rpx 3%","margin":"0 0 12rpx 0","borderColor":"#d8d8d8","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"1"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#223860","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"500"}'>车位类型：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"#666"}'>{{detail.cheweileixing}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"8rpx 3%","margin":"0 0 12rpx 0","borderColor":"#d8d8d8","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"1"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#223860","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"500"}'>收费标准：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"#666"}'>{{detail.shoufeibiaozhun}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"8rpx 3%","margin":"0 0 12rpx 0","borderColor":"#d8d8d8","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"1"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#223860","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"500"}'>停车价格：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"#666"}'>{{detail.tingchejiage}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"8rpx 3%","margin":"0 0 12rpx 0","borderColor":"#d8d8d8","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"1"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#223860","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"500"}'>车位状态：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"#666"}'>{{detail.cheweizhuangtai}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"8rpx 3%","margin":"0 0 12rpx 0","borderColor":"#d8d8d8","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"1"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#223860","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"500"}'>评论数：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"#666"}'>{{detail.discussnum}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"8rpx 3%","margin":"0 0 12rpx 0","borderColor":"#d8d8d8","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"1"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#223860","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"500"}'>收藏数：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"#666"}'>{{detail.storeupnum}}</view>
				</view>





				<view class="detail-list-item rich" :style='{"padding":"12rpx 4%","margin":"0 0 24rpx 0","borderColor":"#d8d8d8","borderWidth":"0 0 0px 0","background":"linear-gradient(30deg, rgba(246,249,255,1) 0%, rgba(239,244,255,1) 100%),#f1f6ff","display":"flex","clipPath":"polygon(2% 0, 100% 0, 98% 100%, 0% 100%)","width":"100%","borderStyle":"solid","height":"auto","order":"2"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"500"}'>车位详情</view>
					<view class="rich-text" :style='{"padding":"0px 24rpx 0 0","margin":"0","lineHeight":"48rpx","color":"#666","flex":"1"}'>
						<rich-text :nodes="detail.cheweixiangqing"></rich-text>
					</view>
				</view>


				<view class="time-content" :style='{"padding":"0px","margin":"40rpx 0 24rpx 0","borderRadius":"0px","background":"#fff","width":"100%","height":"auto","order":"7"}'>
					<view class="comoment-header" :style='{"borderRadius":"0px","background":"radial-gradient(circle, rgba(112,139,187,1) 0%, rgba(81,109,159,1) 100%),#223860","display":"flex","clipPath":"polygon(2% 0, 100% 0, 98% 100%, 0% 100%)","width":"100%","justifyContent":"space-between","height":"auto"}'>
						<view :style='{"padding":"0 40rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#fff","background":"none"}'>评论</view>
						<view :style='{"padding":"0 40rpx 0 20rpx","borderRadius":"0","background":"none","display":"flex"}' @click="onCommentTap" class="btn-comment-content" style="display: flex;align-items: center;">
							<view :style='{"margin":"0 8rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#fff"}' class="cuIcon-add"></view>
							<view :style='{"color":"#fff","lineHeight":"80rpx","fontSize":"28rpx"}'>添加评论</view>
						</view>
					</view>
				
					<view :style='{"padding":"24rpx 32rpx","margin":"24rpx 0 0 0","borderRadius":"0px","background":"linear-gradient(30deg, rgba(246,249,255,1) 0%, rgba(239,244,255,1) 100%),#f1f6ff","clipPath":"polygon(2% 0, 100% 0, 98% 100%, 0% 100%)","width":"100%","height":"auto"}' v-for="(item,index) in commentList" v-bind:key="index" class="cu-item comment-item">
						<view :style='{"width":"100%","display":"flex","height":"auto"}'>
							<image :style='{"width":"60rpx","margin":"0 8rpx 0 0","borderRadius":"100%","display":"block","height":"60rpx"}' v-if="item.avatarurl" mode="aspectFill" :src="baseUrl+item.avatarurl"></image>
							<view :style='{"color":"#333","lineHeight":"60rpx","fontSize":"28rpx"}' class="text-grey">{{item.nickname}}</view>
						</view>
						<view :style='{"margin":"8rpx 0","lineHeight":"1.5","fontSize":"28rpx","color":"#666","textIndent":"2em"}' class="text-gray text-content text-df">
							<rich-text :nodes="item.content"></rich-text>
						</view>
						<view :style='{"lineHeight":"48rpx","fontSize":"26rpx","color":"#999","textAlign":"right"}' class="margin-top-sm text-gray text-df">{{item.addtime}}</view>
						<view v-if="item.reply" :style='{"margin":"8rpx 0","lineHeight":"1.5","fontSize":"28rpx","color":"#666","textIndent":"2em"}' class="text-gray text-content text-df">
							回复:<rich-text :nodes="item.reply"></rich-text>
						</view>
						<view style="display: flex;display: flex;justify-content: flex-end;padding: 6rpx 0;" v-if="user&&user.id==item.userid">
							<view style="color: #999;font-size: 16rpx;" @click="delClick(item.id)">删除</view>
						</view>
					</view>
				</view>

				<view class="bottom-content bg-white tabbar border shop" :style='{"padding":"0","margin":"40rpx 0 24rpx 0","borderRadius":"16rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","height":"auto","order":"4"}'>

					<button :style='{"border":"0","padding":"0 20rpx","boxShadow":"0px 2rpx 4rpx #ccc","margin":"0 3% 20rpx 0","color":"#333","borderRadius":"8rpx","background":"#f1f6ff","width":"auto","fontSize":"28rpx","minWidth":"21%","lineHeight":"72rpx","height":"72rpx"}' v-if="userid&&isAuth('cheweixinxi','预定')" @tap="onAcrossTap('yudingchewei','','cheweizhuangtai','占用',cheweizhuangtaiCrossSelect[0])" class="cu-btn bg-brown round shadow-blur" >预定</button>
					<button :style='{"border":"0","padding":"0 20rpx","boxShadow":"0px 2rpx 4rpx #ccc","margin":"0 3% 20rpx 0","color":"#333","borderRadius":"8rpx","background":"#f1f6ff","width":"auto","fontSize":"28rpx","minWidth":"21%","lineHeight":"72rpx","height":"72rpx"}' v-if="!userid&&isAuthFront('cheweixinxi','预定')" @tap="onAcrossTap('yudingchewei','','cheweizhuangtai','占用',cheweizhuangtaiCrossSelect[0])" class="cu-btn bg-brown round shadow-blur" >预定</button>
					
				</view>
			</view>

		</view>
	</view>
</mescroll-uni>
</view>
</template>

<script>
	export default {
		data() {
			return {
				startX: 0,
				prevNumList4: '',
				numList4: 0,
				timerList4: null,
				flagList4: false,
				navigationActive: {"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#22386080","height":"16rpx"},
				navigationDefault: {"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#fff","height":"16rpx"},
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				id: '',
                userid: '',
				detail: {},
				swiperList: [],
				commentList: [],
				mescroll: null, //mescroll实例对象
				downOption: {
					auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
				},
				upOption: {
					noMoreSize: 3, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
					textNoMore: '~ 没有更多了 ~',
				},
				hasNext: true,
				user: {},
				storeupFlag: 0,
                cheweizhuangtaiCrossSelect:'占用,空闲'.split(','),
				count: 0,
				timer: null,
				title:'',
			}
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
		},
		async onLoad(options) {
			// #ifdef APP-PLUS
			let page = getCurrentPages()
			this.href = this.baseUrl + 'front/h5/#/' + page[page.length - 1].route
			// #endif
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			this.id = options.id;
            if(options.userid) {
                this.userid = options.userid;
            }
			// 渲染数据
			this.init();
		},
		// #ifdef MP-WEIXIN
		onShareAppMessage(){
			var obj = {
				title: this.title,
				imageUrl: this.swiperList[0]?this.baseUrl + this.swiperList[0]: ''
			}
			return obj
		},
		// #endif
        onUnload() {
            if(this.timer) {
                clearInterval(this.timer);
            }
        },
		async onShow(options) {
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			this.btnColor = this.btnColor.sort(()=> {
				return (0.5-Math.random());
			});
			this.getStoreup();
			let cleanType = uni.getStorageSync('discusscheweixinxiCleanType')
			if(cleanType){
				uni.removeStorageSync('discusscheweixinxiCleanType')
				this.mescroll.num = 1
				this.upCallback(this.mescroll)
				this.init();
			}
			let crossCleanType = uni.getStorageSync('crossCleanType')
            if(crossCleanType) {
				uni.removeStorageSync('crossCleanType')
                res = await this.$api.info('cheweixinxi', this.id);
                this.detail = res.data;
				this.title = this.detail.cheweimingcheng
            }
		},
		destroyed: function() {
			//window.clearInterval(this.inter);
		},
		methods: {
			// 拨打电话
			callClick(row){
				uni.makePhoneCall({
					phoneNumber: row
				})
			},
			// 支付
			onPayTap(){
				if(!this.user){
					return false
				}
				uni.setStorageSync('paytable','cheweixinxi');
				uni.setStorageSync('payObject',this.detail);
				this.$utils.jump('../pay-confirm/pay-confirm?type=1')
			},
            onDetailTap(item) {
                uni.setStorageSync("useridTag",this.userid);
                this.$utils.jump(`./detail?id=${item.id}&userid=`+this.userid)
            },
			// 收藏
			async getStoreup() {
				if(!this.user){
					return false
				}
				let params = {
					page: 1,
					limit: 1,
					refid : this.id,
					tablename : 'cheweixinxi',
					userid: this.user.id,
					type: 1,
				}
				let res = await this.$api.list(`storeup`, params);
				this.storeupFlag = res.data.list.length;
			},
			async shoucang(){
				if(!this.user){
					return false
				}
				let _this = this;
				let params = {
					page: 1,
					limit: 1,
					refid : _this.detail.id,
					tablename : 'cheweixinxi',
					userid: _this.user.id,
					type: 1,
				}
				let res = await _this.$api.list(`storeup`, params);
				if (res.data.list.length == 1) {
					let storeupId = res.data.list[0].id;
					uni.showModal({
						title: '提示',
						content: '是否取消',
						success: async function(res) {
							if (res.confirm) {
								_this.detail.storeupnum--
								await _this.$api.update('cheweixinxi',_this.detail)
								await _this.$api.del('storeup', JSON.stringify([storeupId]));
								_this.$utils.msg('取消成功');
								_this.getStoreup();
							}
						}
					});
					return;
				}
				uni.showModal({
					title: '提示',
					content: '是否收藏',
					success: async function(res) {
						if (res.confirm) {
							await _this.$api.add('storeup', {
								userid: _this.user.id,
								name: _this.detail.cheweimingcheng,
								picture: _this.swiperList[0],
								refid: _this.detail.id,
								tablename: 'cheweixinxi',
                                type: 1
							});
							_this.detail.storeupnum++
							await _this.$api.update('cheweixinxi',_this.detail)
							_this.$utils.msg('收藏成功');
							_this.getStoreup();
						}
					}
				});
			},
			// 跨表
			onAcrossTap(tableName,crossOptAudit,statusColumnName,tips,statusColumnValue){
				if(!this.user){
					return false
				}
				uni.setStorageSync('crossTable','cheweixinxi');
				uni.setStorageSync(`crossObj`, this.detail);
				uni.setStorageSync(`statusColumnName`, statusColumnName);
				uni.setStorageSync(`statusColumnValue`, statusColumnValue);
				uni.setStorageSync(`tips`, tips);
				if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
					var obj = uni.getStorageSync('crossObj');
					for (var o in obj){
						if(o==statusColumnName && obj[o]==statusColumnValue){
							this.$utils.msg(tips);
							return
						}
					}
				}
				this.$utils.jump(`../${tableName}/add-or-update?cross=true`);
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
				
				this.timerList4 = setInterval(this.autoPlayList4, 3000)
				this.flagList4 = false
			},
			// 获取详情
			async init(){
                if(this.timer) {
                    clearInterval(this.timer);
                }
				let res = await this.$api.info('cheweixinxi', this.id);
				this.detail = res.data;

				this.title = this.detail.cheweimingcheng
				// 轮播图片
				this.swiperList = this.detail.cheweitupian ? this.detail.cheweitupian.split(",") : [];
				
				this.prevNumList4 = this.swiperList.length - 1
				this.timerList4 = setInterval(this.autoPlayList4, 3000)

				//修改富文本的图片样式
				this.detail.cheweixiangqing = this.detail.cheweixiangqing.replace(/img src/gi,"img style=\"width:100%;\" src");
			},

			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},

			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				mescroll.resetUpScroll()
			},

			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
                let res = await this.$api.list('discusscheweixinxi', {
					page: mescroll.num,
					limit: 10,
					refid: this.id
				});
				// 如果是第一页数据置空
				if (mescroll.num == 1) this.commentList = [];
				this.commentList = this.commentList.concat(res.data.list);
				if (res.data.list.length == 0) this.hasNext = false;
				mescroll.endSuccess(mescroll.size, this.hasNext);

            },



			onChatTap() {
				this.$utils.jump('../chat/chat')
			},
			// 下载
			download(url){
				let _this = this;
				url=_this.$base.url +  url;
				uni.downloadFile({
					url: url,
					success: (res) => {
						if (res.statusCode === 200) {
							_this.$utils.msg('下载成功');
							 window.open(url);
						}
					}
				});
			},
			//
			onCartTabTap() {
				this.$utils.tab('../shop-cart/shop-cart')
			},
			// 添加评论
			async onCommentTap() {
				if(!this.user){
					return false
				}
				this.$utils.jump(`../discusscheweixinxi/add-or-update?refid=${this.id}`)
			},
			delClick(id){
				let that = this
				uni.showModal({
					title: '提示',
					content: '是否删除此评论？',
					async success(res) {
						if(res.confirm){
							await that.$api.del('discusscheweixinxi',JSON.stringify([id]))
							that.$utils.msg('删除成功')
							that.detail.discussnum--
							await that.$api.update('cheweixinxi',that.detail)
							setTimeout(()=>{
								that.upCallback(that.mescroll)
							},1500)
						}
					}
				})
			},
		}
	}
</script>

<style lang="scss">
	page {
	  --animate-duration: 1s;
	  --animate-delay: 1s;
	  --animate-repeat: 1;
	}
	
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	
	.seat-list {
		display: flex;
		align-items: center;
		flex-wrap: wrap;
		background: #FFFFFF;
		margin: 20upx;
		border-radius: 20upx;
		padding: 20upx;
		font-size: 30upx;
		.seat-item {
			width: 33.33%;
			display: flex;
			align-items: center;
			flex-direction: column;
			margin-bottom: 20upx;
	
			.seat-icon {
				width: 50upx;
				height: 50upx;
				margin-bottom: 10upx;
			}
		}
	}
	
	audio {
		display: flex;
		flex-direction: column;
	}
	
	.audio /deep/ .uni-audio-default {
		width: inherit;
	}
	
	.list-swiper-4 .animate__animated {
		--animate-delay: 300ms;
	}

</style>
