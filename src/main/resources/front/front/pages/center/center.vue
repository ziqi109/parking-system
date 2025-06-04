<template>
	<view class="content">
		<view :style='{"minHeight":"100vh","width":"100%","padding":"24rpx","position":"relative","background":"url(http://codegen.caihongy.cn/20231209/4b8f7a17aa7c4b67911e5bdd6709246f.jpg) no-repeat center top / 100% auto,#fff","height":"auto"}'>
			<view v-if="user&&user.id" :style='{"minHeight":"400rpx","padding":"24rpx 24rpx","margin":"0 0 20rpx 0","borderRadius":"16rpx","background":"none","display":"flex","width":"100%","position":"relative","height":"auto"}' @tap="onPageTap('../user-info/user-info')" class="header" v-bind:class="{'status':isH5Plus}">
				<view :style='{"alignContent":"center","padding":"0","margin":"0","alignItems":"center","flexWrap":"wrap","background":"none","display":"flex","width":"100%","height":"100%"}' v-if="tableName=='yonghu'" class="userinfo">
					<image :style='{"width":"88rpx","padding":"0","margin":"0 20rpx 0 0","borderRadius":"100%","height":"88rpx"}' :src="user.touxiang?baseUrl+user.touxiang:'/static/gen/upload.png'"></image>
					<view :style='{"width":"calc(100% - 108rpx)","flexDirection":"column","justifyContent":"center","display":"flex"}' class="info">
						<view :style='{"width":"100%","lineHeight":"36rpx","fontSize":"28rpx","color":"#fff"}'>{{user.zhanghao}}<text v-if="user.vip&& user.vip=='是'">(VIP)</text></view>
					</view>
					
					<view :style='{"width":"calc(60% - 80rpx)","margin":"140rpx 20rpx 0 15%","position":"relative","flex":"1","display":"flex"}' class="info">
						<view :style='{"margin":"-116rpx 0 0","color":"#fff","left":"0","width":"320rpx","lineHeight":"36rpx","fontSize":"28rpx","position":"absolute"}'>手机：{{user.shouji}}</view>
					</view>
				</view>
				<view :style='{"padding":"8rpx 20rpx","alignItems":"center","top":"24rpx","borderRadius":"16rpx","background":"none","flexDirection":"column","display":"flex","width":"auto","position":"absolute","right":"24rpx","justifyContent":"center","height":"auto"}' class="setting">
					<text class="icon iconfont icon-qita6" :style='{"border":"0","margin":"0 6rpx 0 0","color":"#fff","borderRadius":"0","display":"inline-block","width":"48rpx","lineHeight":"48rpx","fontSize":"48rpx"}'></text>
					<text :style='{"lineHeight":"2","fontSize":"28rpx","color":"#fff","display":"inline-block"}'>设置</text>
				</view>
			</view>
			
			<view v-else :style='{"minHeight":"400rpx","padding":"24rpx 24rpx","margin":"0 0 20rpx 0","borderRadius":"16rpx","background":"none","display":"flex","width":"100%","position":"relative","height":"auto"}' @tap="loginClick" class="header" v-bind:class="{'status':isH5Plus}">
				<view :style='{"alignItems":"center","color":"#fff","display":"flex","width":"100%","fontSize":"36rpx","justifyContent":"center","height":"100%"}'>登录/注册</view>
			</view>
			
			<view :style='{"width":"100%","background":"none","height":"auto"}' class="list">
				
				<view :style='{"width":"100%","padding":"10rpx 6rpx","margin":"40rpx 0 0","borderRadius":"16rpx","background":"#fff","height":"auto"}'>
					<view :style='{"width":"100%","padding":"0 20rpx","background":"none","justifyContent":"space-between","display":"flex","height":"auto"}'>
						<view :style='{"color":"#223860","textAlign":"center","background":"url(http://codegen.caihongy.cn/20231208/dd4367eb2136483aa23e9dc12954f2df.png) no-repeat center top","width":"100%","fontSize":"32rpx","lineHeight":"96rpx","fontWeight":"600","height":"50pz"}'>我的服务</view>
					</view>
					<view :style='{"padding":"20rpx 2% 0 0","flexWrap":"wrap","flexDirection":"row","display":"flex","width":"100%","justifyContent":"flex-start","height":"auto"}'>
					
						<block v-for="item in menuList" v-bind:key="item.roleName">
							<block v-if="role==item.roleName" v-bind:key="menu.menu" v-for="(menu,index) in item.backMenu">
								<block v-bind:key="child.tableName" v-for=" (child,sort) in menu.child">
									<view :style='{"padding":"4rpx 40rpx","borderColor":"#e2e2e2","margin":"0 0 3% 3%","alignItems":"center","display":"flex","clipPath":"polygon(2% 0, 100% 0, 98% 100%, 0% 100%)","justifyContent":"center","borderRadius":"0px","flexWrap":"wrap","borderWidth":"0px","background":"linear-gradient(30deg, rgba(246,249,255,1) 0%, rgba(239,244,255,1) 100%),#f1f6ff","width":"100%","borderStyle":"solid","height":"auto"}' v-if="child.tableName!='yifahuodingdan' && child.tableName!='yituikuandingdan' &&child.tableName!='yiquxiaodingdan' && child.tableName!='weizhifudingdan' && child.tableName!='yizhifudingdan' && child.tableName!='yiwanchengdingdan' && child.tableName!='exampaper' && child.tableName!='examquestion' " @tap="onPageTap('../'+child.tableName+'/list?userid='+user.id+'&menuJump='+child.menuJump)" class="li" hover-class="hover">
										<view :style='{"width":"auto","lineHeight":"1","fontSize":"64rpx","color":"#223860","textAlign":"center"}' :class="child.appFrontIcon"></view>
										<view :style='{"padding":"0 20rpx","margin":"10rpx 0 0","color":"#333","textAlign":"left","flex":"1","width":"auto","fontSize":"28rpx"}' class="text">{{child.menu}}</view>
										<view :style='{"width":"28rpx","lineHeight":"28rpx","fontSize":"28rpx","color":"#999","display":"block"}' class="icon iconfont icon-jinru"></view>
									</view>
								</block>
							</block>
						</block>
						
						<view v-if="user&&user.id" @tap="passwordShow()" :style='{"padding":"4rpx 40rpx","borderColor":"#e2e2e2","margin":"0 0 3% 3%","alignItems":"center","display":"flex","clipPath":"polygon(2% 0, 100% 0, 98% 100%, 0% 100%)","justifyContent":"center","borderRadius":"0px","flexWrap":"wrap","borderWidth":"0px","background":"linear-gradient(30deg, rgba(246,249,255,1) 0%, rgba(239,244,255,1) 100%),#f1f6ff","width":"100%","borderStyle":"solid","height":"auto"}' class="li" hover-class="hover">
							<view :style='{"width":"auto","lineHeight":"1","fontSize":"64rpx","color":"#223860","textAlign":"center"}' class="cuIcon-lock"></view>
							<view class="text" :style='{"padding":"0 20rpx","margin":"10rpx 0 0","color":"#333","textAlign":"left","flex":"1","width":"auto","fontSize":"28rpx"}'>修改密码</view>
							<view :style='{"width":"28rpx","lineHeight":"28rpx","fontSize":"28rpx","color":"#999","display":"block"}' class="icon iconfont icon-jinru"></view>
						</view>
					</view>
				</view>
			</view>
			
			<!-- 推荐 -->
			<view style="width: 100%;height: 80px"></view>
		</view>
		<uni-popup class="popup-content" ref="passwordPopup" type="bottom">
			<view class="passwordForm">
				<view class="passwordInput">
					<input type="password" v-model="passwordForm.mima" placeholder="原密码" />
				</view>
				<view class="passwordInput">
					<input type="password" v-model="passwordForm.newmima" placeholder="新密码" />
				</view>
				<view class="passwordInput">
					<input type="password" v-model="passwordForm.newmima1" placeholder="确认密码" />
				</view>
				<view class="passwordBtnView">
					<button class="passwordBtn" @click="updatePassword">更新</button>
				</view>
			</view>
		</uni-popup>
	</view>
</template>
<script>
	import menu from '@/utils/menu'
	export default {
		data() {
			return {
				isH5Plus: true,
				user: {},
				tableName:'',
				role: '',
				menuList: [],
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
				passwordForm: {
					mima: '',
					newmima: '',
					newmima1: '',
				},
			};
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
		},
		async onLoad(){
			let menus = menu.list();
			this.menuList = menus;
		},
		async onShow(){
            uni.removeStorageSync("useridTag");
			this.role = uni.getStorageSync("role");
			await this.getSession()
			this.getThumbsup()
			this.getStoreup()
			this.tableName = uni.getStorageSync("nowTable");
			let menus = menu.list();
			this.menuList = menus;
		},
		methods: {
			async getSession(){
				let table = uni.getStorageSync("nowTable");
				let res = await this.$api.session(table);
				this.user = res.data;
				this.$forceUpdate()
			},
			async getThumbsup(){
				if(!this.user||!this.user.id){
					return false
				}
				let res = await this.$api.page('storeup',{userid: this.user.id,type: 21})
				this.user.thumbsnum = Number(res.data.total)
				this.$forceUpdate()
			},
			async getStoreup(){
				if(!this.user||!this.user.id){
					return false
				}
				let res = await this.$api.page('storeup',{userid: this.user.id,type: 1})
				this.user.storenum = Number(res.data.total)
				this.$forceUpdate()
			},
			loginClick(){
				uni.navigateTo({
					url: '../login/login'
				});
			},
			onPageTap(url) {
                uni.setStorageSync("useridTag",1);
				uni.navigateTo({
					url: url,
					fail: function() {
						uni.switchTab({
							url: url
						});
					}
				});
			},
			recommendDetail(id) {
				uni.navigateTo({
					url: `../${this.recommendTable}/detail?id=${id}`,
					fail: function() {
						uni.switchTab({
							url: `../${this.recommendTable}/detail?id=${id}`
						});
					}
				});
			},
			passwordShow() {
				this.passwordForm = {
					mima: '',
					newmima: '',
					newmima1: '',
				}
				this.$forceUpdate()
				this.$refs.passwordPopup.open()
			},
			async updatePassword() {
				if (this.passwordForm.mima == ''){
					this.$utils.msg('原密码不能为空')
					return false
				}
				if (this.passwordForm.newmima == ''){
					this.$utils.msg('新密码不能为空')
					return false
				}
				if (this.passwordForm.newmima1 == ''){
					this.$utils.msg('确认密码不能为空')
					return false
				}
				let password = ''
				if (this.user.mima) {
					password = this.user.mima;
				} else if (this.user.password) {
					password = this.user.password;
				}
				let newpassword = this.passwordForm.mima
				if(password != newpassword){
					this.$utils.msg('原密码不正确')
					return false
				}
				if (this.passwordForm.newmima != this.passwordForm.newmima1){
					this.$utils.msg('两次密码不一致')
					return false
				}
				if (this.tableName == 'yonghu') {
				}
				this.user.password = this.passwordForm.newmima
				this.user.mima = this.passwordForm.newmima
				await this.$api.update(this.tableName,this.user)
				this.$utils.msg('修改密码成功,下次登录系统生效')
				this.$refs.passwordPopup.close()
				this.getSession()
			},
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		height: calc(100vh - 94px);
		box-sizing: border-box;
	}
	.passwordForm {
		width: 100%;
		padding: 10px 20px 60px;
		background: #fff;
	
		.passwordInput {
			background: #eee;
			margin: 0 0 10px;
			padding: 0 10px;
	
			input {
				height: 36px;
				line-height: 36px;
				font-size: 14px;
			}
		}
	
		.passwordBtnView {
			width: 100%;
			display: flex;
			align-items: center;
			justify-content: center;
			padding: 10px 0;
	
			.passwordBtn {
				padding: 0 20px;
				width: auto;
				height: 20px;
				line-height: 20px;
				font-size: 14px;
				color: #fff;
				background: #007aff;
				border: none;
				border-radius: 5px;
	
			}
		}
	}
</style>
