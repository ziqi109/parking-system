
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

				<view :style='{"padding":"8rpx 3%","margin":"0 0 12rpx 0","borderColor":"#d8d8d8","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"1"}' class="detail-list-item title">
					<view :style='{"padding":"0 20rpx 0 0","color":"#223860","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"500"}' class="lable">车位名称：</view>
					<view :style='{"padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"#666"}' class="text">{{detail.cheweimingcheng}}</view>
				</view>
				<view :style='{"padding":"8rpx 3%","margin":"0 0 12rpx 0","borderColor":"#d8d8d8","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"1"}' class="detail-list-item title">
					<view :style='{"padding":"0 20rpx 0 0","color":"#223860","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"500"}' class="lable">预订状态：</view>
					<view :style='{"padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"#666"}' class="text">{{detail.yudingzhuangtai}}</view>
				</view>
				<view :style='{"padding":"8rpx 3%","margin":"0 0 12rpx 0","borderColor":"#d8d8d8","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"1"}' class="detail-list-item title">
					<view :style='{"padding":"0 20rpx 0 0","color":"#223860","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"500"}' class="lable">状态：</view>
					<view :style='{"padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"#666"}' class="text">{{detail.zhuangtai}}</view>
				</view>

				<view class="detail-list-item" :style='{"padding":"8rpx 3%","margin":"0 0 12rpx 0","borderColor":"#d8d8d8","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"1"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#223860","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"500"}'>车位编号：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"#666"}'>{{detail.cheweibianhao}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"8rpx 3%","margin":"0 0 12rpx 0","borderColor":"#d8d8d8","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"1"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#223860","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"500"}'>车位类型：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"#666"}'>{{detail.cheweileixing}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"8rpx 3%","margin":"0 0 12rpx 0","borderColor":"#d8d8d8","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"1"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#223860","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"500"}'>车位位置：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"#666"}'>{{detail.cheweiweizhi}}</view>
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
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#223860","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"500"}'>账号：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"#666"}'>{{detail.zhanghao}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"8rpx 3%","margin":"0 0 12rpx 0","borderColor":"#d8d8d8","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"1"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#223860","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"500"}'>姓名：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"#666"}'>{{detail.xingming}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"8rpx 3%","margin":"0 0 12rpx 0","borderColor":"#d8d8d8","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"1"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#223860","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"500"}'>手机：</view>
					<view style="text-decoration: underline" @tap="callClick(detail.shouji)"  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"#666"}'>{{detail.shouji}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"8rpx 3%","margin":"0 0 12rpx 0","borderColor":"#d8d8d8","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"1"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#223860","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"500"}'>车牌号码：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"#666"}'>{{detail.chepaihaoma}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"8rpx 3%","margin":"0 0 12rpx 0","borderColor":"#d8d8d8","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"1"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#223860","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"500"}'>预定时间：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"#666"}'>{{detail.yudingshijian}}</view>
				</view>




				<view v-if="userid" class="detail-list-item" :style='{"padding":"8rpx 3%","margin":"0 0 12rpx 0","borderColor":"#d8d8d8","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"1"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#223860","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"500"}'>审核状态：</view>
					<view v-if="detail.sfsh=='是'" class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"#666"}'>通过</view>
					<view v-if="detail.sfsh=='否'" class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"#666"}'>不通过</view>
					<view v-if="detail.sfsh=='待审核'" class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"#666"}'>待审核</view>
				</view>
				<view v-if="userid" class="detail-list-item" :style='{"padding":"8rpx 3%","margin":"0 0 12rpx 0","borderColor":"#d8d8d8","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"1"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#223860","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"500"}'>审核回复</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"#666"}'>{{detail.shhf}}</view>
				</view>




				<view class="bottom-content bg-white tabbar border shop" :style='{"padding":"0","margin":"40rpx 0 24rpx 0","borderRadius":"16rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","height":"auto","order":"4"}'>

					<button :style='{"border":"0","padding":"0 20rpx","boxShadow":"0px 2rpx 4rpx #ccc","margin":"0 3% 20rpx 0","color":"#333","borderRadius":"8rpx","background":"#f1f6ff","width":"auto","fontSize":"28rpx","minWidth":"21%","lineHeight":"72rpx","height":"72rpx"}' v-if="userid&&isAuth('yudingchewei','入场')" @tap="onAcrossTap('cheliangruchang','是','zhuangtai','已入场',zhuangtaiCrossSelect[0])" class="cu-btn bg-brown round shadow-blur" >入场</button>
					<button :style='{"border":"0","padding":"0 20rpx","boxShadow":"0px 2rpx 4rpx #ccc","margin":"0 3% 20rpx 0","color":"#333","borderRadius":"8rpx","background":"#f1f6ff","width":"auto","fontSize":"28rpx","minWidth":"21%","lineHeight":"72rpx","height":"72rpx"}' v-if="!userid&&isAuthFront('yudingchewei','入场')" @tap="onAcrossTap('cheliangruchang','是','zhuangtai','已入场',zhuangtaiCrossSelect[0])" class="cu-btn bg-brown round shadow-blur" >入场</button>
					<button :style='{"border":"0","padding":"0 20rpx","boxShadow":"0px 2rpx 4rpx #ccc","margin":"0 3% 20rpx 0","color":"#333","borderRadius":"8rpx","background":"#f1f6ff","width":"auto","fontSize":"28rpx","minWidth":"21%","lineHeight":"72rpx","height":"72rpx"}' v-if="userid&&isAuth('yudingchewei','取消预定')" @tap="onAcrossTap('quxiaoyuding','是','yudingzhuangtai','已取消',yudingzhuangtaiCrossSelect[0])" class="cu-btn bg-brown round shadow-blur" >取消预定</button>
					<button :style='{"border":"0","padding":"0 20rpx","boxShadow":"0px 2rpx 4rpx #ccc","margin":"0 3% 20rpx 0","color":"#333","borderRadius":"8rpx","background":"#f1f6ff","width":"auto","fontSize":"28rpx","minWidth":"21%","lineHeight":"72rpx","height":"72rpx"}' v-if="!userid&&isAuthFront('yudingchewei','取消预定')" @tap="onAcrossTap('quxiaoyuding','是','yudingzhuangtai','已取消',yudingzhuangtaiCrossSelect[0])" class="cu-btn bg-brown round shadow-blur" >取消预定</button>
					<button :style='{"border":"0","padding":"0 20rpx","boxShadow":"0px 2rpx 4rpx #ccc","margin":"0 3% 20rpx 0","color":"#333","borderRadius":"8rpx","background":"#f1f6ff","width":"auto","fontSize":"28rpx","minWidth":"20%","lineHeight":"72rpx","height":"72rpx"}' v-if="userid&&isAuth('yudingchewei','审核')" @tap="onSHTap">审核</button>
					<button :style='{"border":"0","padding":"0 20rpx","boxShadow":"0px 2rpx 4rpx #ccc","margin":"0 3% 20rpx 0","color":"#333","borderRadius":"8rpx","background":"#f1f6ff","width":"auto","fontSize":"28rpx","minWidth":"20%","lineHeight":"72rpx","height":"72rpx"}' v-if="!userid&&isAuthFront('yudingchewei','审核')" @tap="onSHTap">审核</button>
					
				</view>
			</view>

		</view>
		<!-- 确认完成弹窗 -->
		<uni-popup class="popup-content" ref="popup" type="center">
			<form class="popup-form" style="background: #fff;width: 300px;display: block;border-radius: 10px;padding: 20px;text-align: center;">
				<view class=" margin-top">
					<picker @change="sfshChange" :value="sfshIndex" :range="sfshOptions">
						<view class="uni-input">{{detail.sfsh?detail.sfsh:'选择审核结果'}}</view>
					</picker>
				</view>
				<view class="">
					<!-- <view class="title">审核回复</view> -->
					<textarea style="width: 200px;" v-model="detail.shhf" placeholder="审核回复"></textarea>
					<!-- <input v-model="douyinId" placeholder="审核回复" name="input"></input> -->
				</view>
				<view class="btn-content">
					<button style="margin: 0 10px" @tap="onCloseWinTap" class="cu-btn bg-cyan">取消</button>
					<button style="margin: 0 10px" @tap="onFinishTap" class="cu-btn bg-red">确认</button>
				</view>
			</form>
		</uni-popup>
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
				sfshIndex: -1,
				sfshOptions: ['通过','不通过', '待审核'],
                zhuangtaiCrossSelect:'已入场,待入场'.split(','),
                yudingzhuangtaiCrossSelect:'已取消,正常'.split(','),
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
			let crossCleanType = uni.getStorageSync('crossCleanType')
            if(crossCleanType) {
				uni.removeStorageSync('crossCleanType')
                res = await this.$api.info('yudingchewei', this.id);
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
                if(this.detail.sfsh!='是') {
                	this.$utils.msg("请审核通过后再操作");
                	return
                }
				uni.setStorageSync('paytable','yudingchewei');
				uni.setStorageSync('payObject',this.detail);
				this.$utils.jump('../pay-confirm/pay-confirm?type=1')
			},
            onDetailTap(item) {
                uni.setStorageSync("useridTag",this.userid);
                this.$utils.jump(`./detail?id=${item.id}&userid=`+this.userid)
            },
			// 跨表
			onAcrossTap(tableName,crossOptAudit,statusColumnName,tips,statusColumnValue){
				if(!this.user){
					return false
				}
				if(crossOptAudit=='是'&&this.detail.sfsh!='是') {
					this.$utils.msg("请审核通过后再操作");
					return
				}
				uni.setStorageSync('crossTable','yudingchewei');
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
				let res = await this.$api.info('yudingchewei', this.id);
				this.detail = res.data;

				this.title = this.detail.cheweimingcheng
				// 轮播图片
				this.swiperList = this.detail.cheweitupian ? this.detail.cheweitupian.split(",") : [];
				
				this.prevNumList4 = this.swiperList.length - 1
				this.timerList4 = setInterval(this.autoPlayList4, 3000)

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
			onSHTap() {
				if(this.detail.sfsh=='是'||this.detail.sfsh=='否') {
				    this.$utils.msg('已审核完成');
				    return;
				}
				this.$refs.popup.open()
			},
			// 完成审核
			async onFinishTap() {
				if(!this.detail.sfsh){
					this.$utils.msg('请选择审核状态');
					return
				}
				if(!this.detail.shhf){
					this.$utils.msg('请填写审核回复');
					return
				}
				if(this.detail.sfsh=="通过"){
					this.detail.sfsh = '是'
				}
				if(this.detail.sfsh=="不通过"){
					this.detail.sfsh = '否'
				}
				if(this.detail.sfsh=="待审核"){
					this.detail.sfsh = '待审核'
				}
				await this.$api.update('yudingchewei', this.detail);
				this.$utils.msg('审核成功');
				this.$refs.popup.close();
			},
			// 关闭窗口
			onCloseWinTap() {
				this.$refs.popup.close()
			},
			sfshChange(e){
				console.log(this.detail)
				this.sfshIndex = e.target.value
				this.detail.sfsh = this.sfshOptions[this.sfshIndex]
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
