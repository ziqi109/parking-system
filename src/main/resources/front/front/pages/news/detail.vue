
<template>
<view>
<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback">
	<view class="content">
		<view class="container" :style='{"minHeight":"100vh","width":"100%","padding":"0px","position":"relative","background":"linear-gradient(0deg, rgba(255,255,255,1) 90%, rgba(34,56,96,1) 95%, rgba(34,56,96,1) 100%),#fff","height":"auto"}'>
            <view :style='{"padding":"0 24rpx","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}' class="detail-content">
				<view :style='{"width":"auto","padding":"0 20rpx","float":"right","textAlign":"right"}' v-if="storeupFlag==1" @click="shoucang">
					<text class="icon iconfont icon-shoucang04" :style='{"margin":"0 4rpx 0 0","lineHeight":"80rpx","fontSize":"36rpx","color":"#f15b12"}'></text>
					<text :style='{"color":"#f15b12","lineHeight":"80rpx","fontSize":"28rpx"}'>收藏</text>
				</view>
				<view :style='{"width":"auto","padding":"0 20rpx","float":"right","textAlign":"right"}' v-if="storeupFlag==0" @click="shoucang">
					<text class="icon iconfont icon-shoucang04" :style='{"margin":"0 4rpx 0 0","lineHeight":"80rpx","fontSize":"36rpx","color":"#f15b12"}'></text>
					<text :style='{"color":"#f15b12","lineHeight":"80rpx","fontSize":"28rpx"}'>收藏</text>
				</view>


				<view class="detail-list-item" :style='{"padding":"8rpx 3%","margin":"0 0 12rpx 0","borderColor":"#d8d8d8","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"1"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#223860","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"500"}'>标题：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"#666"}'>{{detail.title}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"8rpx 3%","margin":"0 0 12rpx 0","borderColor":"#d8d8d8","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"1"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#223860","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"500"}'>分类名称：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"#666"}'>{{detail.typename}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"8rpx 3%","margin":"0 0 12rpx 0","borderColor":"#d8d8d8","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"1"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#223860","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"500"}'>发布人：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"#666"}'>{{detail.name}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"8rpx 3%","margin":"12rpx 0 24rpx 0","borderColor":"#ccc","borderWidth":"0 0 0px 0","background":"linear-gradient(30deg, rgba(246,249,255,1) 0%, rgba(239,244,255,1) 100%),#f1f6ff","display":"flex","clipPath":"polygon(1% 0, 100% 0%, 99% 100%, 0% 100%)","width":"100%","borderStyle":"solid","height":"auto","order":"3"}'>
      		        <image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-if="detail.headportrait" :src="baseUrl+detail.headportrait"></image>
				</view>
				<view class="detail-list-item" :style='{"padding":"8rpx 3%","margin":"0 0 12rpx 0","borderColor":"#d8d8d8","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"1"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#223860","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"500"}'>点击次数：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"#666"}'>{{detail.clicknum}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"8rpx 3%","margin":"0 0 12rpx 0","borderColor":"#d8d8d8","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"1"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#223860","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"500"}'>收藏数：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"#666"}'>{{detail.storeupnum}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"8rpx 3%","margin":"12rpx 0 24rpx 0","borderColor":"#ccc","borderWidth":"0 0 0px 0","background":"linear-gradient(30deg, rgba(246,249,255,1) 0%, rgba(239,244,255,1) 100%),#f1f6ff","display":"flex","clipPath":"polygon(1% 0, 100% 0%, 99% 100%, 0% 100%)","width":"100%","borderStyle":"solid","height":"auto","order":"3"}'>
      		        <image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-if="detail.picture" :src="baseUrl+detail.picture"></image>
				</view>

				<view :style='{"padding":"0 40rpx","margin":"0 0 0px 0","borderColor":"#ccc","textAlign":"center","display":"inline-block","clipPath":"polygon(5% 0, 100% 0, 95% 100%, 0% 100%)","minWidth":"48%","float":"left","borderRadius":"0px","borderWidth":"0 0 0px 0","background":"radial-gradient(circle, rgba(112,139,187,1) 0%, rgba(81,109,159,1) 100%),#223860","width":"auto","borderStyle":"solid","height":"auto","order":"3"}' class="detail-list-item" v-if="!thumbsupFlag&&!crazilyFlag" @tap="zan">
					<view :style='{"padding":"0 10rpx 0 0","color":"#fff","display":"inline-block","width":"auto","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"500"}' class="lable">赞：</view>
					<view :style='{"width":"auto","flex":"1","justifyContent":"space-between","display":"inline-block","height":"auto"}'>
						<view :style='{"lineHeight":"80rpx","fontSize":"28rpx","color":"#fff","display":"inline-block"}'>{{detail.thumbsupnum}}</view>
						<view :style='{"margin":"0 0 0 40rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#fff","display":"inline-block"}' class="cuIcon-appreciate"></view>
					</view>
				</view>
				<view :style='{"padding":"0 40rpx","margin":"0 0 0px 0","borderColor":"#ccc","textAlign":"center","display":"inline-block","clipPath":"polygon(5% 0, 100% 0, 95% 100%, 0% 100%)","minWidth":"48%","float":"left","borderRadius":"0px","borderWidth":"0 0 0px 0","background":"radial-gradient(circle, rgba(112,139,187,1) 0%, rgba(81,109,159,1) 100%),#223860","width":"auto","borderStyle":"solid","height":"auto","order":"3"}' class="detail-list-item" v-if="thumbsupFlag" @tap="zan">
					<view :style='{"padding":"0 10rpx 0 0","color":"#fff","display":"inline-block","width":"auto","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"500"}' class="lable">已赞：</view>
					<view :style='{"width":"auto","flex":"1","justifyContent":"space-between","display":"inline-block","height":"auto"}'>
						<view :style='{"lineHeight":"80rpx","fontSize":"28rpx","color":"#fff","display":"inline-block"}'>{{detail.thumbsupnum}}</view>
						<view :style='{"margin":"0 0 0 40rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#fff","display":"inline-block"}' class="cuIcon-appreciate"></view>
					</view>
				</view>
				<view :style='{"padding":"0 40rpx","margin":"0 0 0px 0","borderColor":"#c4c4c4","textAlign":"center","display":"inline-block","clipPath":"polygon(5% 0, 100% 0, 95% 100%, 0% 100%)","minWidth":"48%","float":"right","borderRadius":"0px","borderWidth":"0px","background":"radial-gradient(circle, rgba(228,228,228,1) 0%, rgba(191,191,191,1) 100%),#bfbfbf","width":"auto","borderStyle":"solid","height":"auto","order":"3"}' class="detail-list-item" v-if="!thumbsupFlag&&!crazilyFlag" @tap="cai">
					<view :style='{"width":"auto","padding":"0 10rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","display":"inline-block"}' class="lable">踩：</view>
					<view :style='{"width":"auto","flex":"1","justifyContent":"space-between","display":"inline-block","height":"auto"}'>
						<view :style='{"lineHeight":"80rpx","fontSize":"28rpx","color":"#333","display":"inline-block"}'>{{detail.crazilynum}}</view>
						<view style="transform: rotate(180deg);" :style='{"margin":"0 0 0 40rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","display":"inline-block"}' class="cuIcon-appreciate"></view>
					</view>
				</view>
				<view :style='{"padding":"0 40rpx","margin":"0 0 0px 0","borderColor":"#c4c4c4","textAlign":"center","display":"inline-block","clipPath":"polygon(5% 0, 100% 0, 95% 100%, 0% 100%)","minWidth":"48%","float":"right","borderRadius":"0px","borderWidth":"0px","background":"radial-gradient(circle, rgba(228,228,228,1) 0%, rgba(191,191,191,1) 100%),#bfbfbf","width":"auto","borderStyle":"solid","height":"auto","order":"3"}' class="detail-list-item" v-if="crazilyFlag" @tap="cai">
					<view :style='{"width":"auto","padding":"0 10rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","display":"inline-block"}' class="lable">踩：</view>
					<view :style='{"width":"auto","flex":"1","justifyContent":"space-between","display":"inline-block","height":"auto"}'>
						<view :style='{"lineHeight":"80rpx","fontSize":"28rpx","color":"#333","display":"inline-block"}'>{{detail.crazilynum}}</view>
						<view style="transform: rotate(180deg);" :style='{"margin":"0 0 0 40rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","display":"inline-block"}' class="cuIcon-appreciate"></view>
					</view>
				</view>


				<view class="detail-list-item" :style='{"padding":"8rpx 3%","margin":"0 0 12rpx 0","borderColor":"#d8d8d8","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto","order":"1"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#223860","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"500"}'>简介</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"48rpx","fontSize":"28rpx","color":"#666"}'>{{detail.introduction}}</view>
				</view>


				<view class="detail-list-item rich" :style='{"padding":"12rpx 4%","margin":"0 0 24rpx 0","borderColor":"#d8d8d8","borderWidth":"0 0 0px 0","background":"linear-gradient(30deg, rgba(246,249,255,1) 0%, rgba(239,244,255,1) 100%),#f1f6ff","display":"flex","clipPath":"polygon(2% 0, 100% 0, 98% 100%, 0% 100%)","width":"100%","borderStyle":"solid","height":"auto","order":"2"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"auto","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"500"}'>内容</view>
					<view class="rich-text" :style='{"padding":"0px 24rpx 0 0","margin":"0","lineHeight":"48rpx","color":"#666","flex":"1"}'>
						<rich-text :nodes="detail.content"></rich-text>
					</view>
				</view>



				<view class="bottom-content bg-white tabbar border shop" :style='{"padding":"0","margin":"40rpx 0 24rpx 0","borderRadius":"16rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","height":"auto","order":"4"}'>

					
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
				thumbsupFlag: 0,
				crazilyFlag: 0,
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
			this.getThumbsup();
			let crossCleanType = uni.getStorageSync('crossCleanType')
            if(crossCleanType) {
				uni.removeStorageSync('crossCleanType')
                res = await this.$api.info('news', this.id);
                this.detail = res.data;
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
				uni.setStorageSync('paytable','news');
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
					tablename : 'news',
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
					tablename : 'news',
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
								await _this.$api.update('news',_this.detail)
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
                                inteltype: _this.detail.typename,
								picture: _this.swiperList[0],
								refid: _this.detail.id,
								tablename: 'news',
                                type: 1
							});
							_this.detail.storeupnum++
							await _this.$api.update('news',_this.detail)
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
				uni.setStorageSync('crossTable','news');
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
				let res = await this.$api.info('news', this.id);
				this.detail = res.data;

				//修改富文本的图片样式
				this.detail.content = this.detail.content.replace(/img src/gi,"img style=\"width:100%;\" src");
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
			// 获取赞踩
			async getThumbsup() {
				if(!this.user){
					return false
				}
				let params = {
					page: 1,
					limit: 1,
					refid: this.id,
					tablename: 'news',
					userid: this.user.id,
					type: '%2%',
				}
				let res = await this.$api.list(`storeup`, params);
				if (res.data.list.length > 0) {
					if(res.data.list[0].type=='21') {
						this.thumbsupFlag = 1;
					} else {
						this.crazilyFlag = 1;
					}
				}

			},
			// 点赞
			async zan() {
				if(!this.user){
					return false
				}
				let _this = this;
				let params = {
					page: 1,
					limit: 1,
					refid: _this.detail.id,
					tablename : 'news',
					userid: _this.user.id,
					type: '%2%',
				}
				let res = await _this.$api.list(`storeup`, params);
				if (res.data.list.length > 0) {
					let storeupId = res.data.list[0].id;
					uni.showModal({
						title: '提示',
						content: '是否取消点赞',
						success: async function(res) {
							if (res.confirm) {
								await _this.$api.del('storeup', JSON.stringify([storeupId]));
								_this.detail.thumbsupnum = parseInt(_this.detail.thumbsupnum) - 1;
								await _this.$api.update('news', _this.detail);
								_this.$utils.msg('取消成功');
								_this.thumbsupFlag=0;
							}
						}
					});
					return;
				}
				uni.showModal({
					title: '提示',
					content: '是否点赞',
					success: async function(res) {
						if (res.confirm) {
							await _this.$api.add('storeup', {
								userid: _this.user.id,
								picture: _this.swiperList[0],
								refid: _this.detail.id,
								tablename: 'news',
								type: '21'
							});
							_this.detail.thumbsupnum = parseInt(_this.detail.thumbsupnum) + 1;
							await _this.$api.update('news', _this.detail);
							_this.$utils.msg('点赞成功');
							_this.thumbsupFlag=1;
						}
					}
				});
			},
			// 踩
			async cai() {
				if(!this.user){
					return false
				}
				let _this = this;
				let params = {
					page: 1,
					limit: 1,
					refid: _this.detail.id,
					tablename: 'news',
					userid: _this.user.id,
					type: '%2%',
				}
				let res = await _this.$api.list(`storeup`, params);
				if (res.data.list.length > 0) {
					let storeupId = res.data.list[0].id;
					uni.showModal({
						title: '提示',
						content: '是否取消点踩',
						success: async function(res) {
							if (res.confirm) {
								await _this.$api.del('storeup', JSON.stringify([storeupId]));
								_this.detail.crazilynum = parseInt(_this.detail.crazilynum) - 1;
								await _this.$api.update('news', _this.detail);
								_this.$utils.msg('取消成功');
								_this.crazilyFlag=0;
							}
						}
					});
					return;
				}
				uni.showModal({
					title: '提示',
					content: '是否点踩',
					success: async function(res) {
						if (res.confirm) {
							await _this.$api.add('storeup', {
								userid: _this.user.id,
								picture: _this.swiperList[0],
								refid: _this.detail.id,
								tablename: 'news',
								type: '22'
							});
							_this.detail.crazilynum = parseInt(_this.detail.crazilynum) + 1;
							await _this.$api.update('news', _this.detail);
							_this.$utils.msg('点踩成功');
							_this.crazilyFlag=1;
						}
					}
				});
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
