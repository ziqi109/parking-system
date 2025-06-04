<template>
	<view :style='{"minHeight":"100vh","padding":"24rpx 0","flexWrap":"wrap","background":"linear-gradient(0deg, rgba(255,255,255,1) 95%, rgba(34,56,96,1) 95%, rgba(34,56,96,1) 100%),#fff","display":"flex","width":"100%","position":"relative","justifyContent":"space-between","height":"auto"}'>
		<view class="title" :style='{"padding":"20rpx 0 0","margin":"0","color":"#333","borderRadius":"60rpx 60rpx 0 0","textAlign":"center","background":"#fff","width":"100%","lineHeight":"80rpx","fontSize":"32rpx"}'>{{detail.title}}</view>
		
		<view :style='{"border":"0","padding":"0 24rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","justifyContent":"center"}'>
		  <view :style='{"padding":"0","margin":"0 20rpx 0 0","order":"5"}'>
		    <text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#999"}'></text>
		    <text :style='{"color":"#999","lineHeight":"1.5","fontSize":"24rpx"}'>发布时间：{{detail.addtime}}</text>
		  </view>
		  <view :style='{"padding":"0","margin":"0 20rpx 0 0"}'>
		    <text class="icon iconfont icon-geren11" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#999"}'></text>
		    <text :style='{"color":"#999","lineHeight":"1.5","fontSize":"24rpx"}'>{{detail.name}}</text>
		  </view>
		  <view :style='{"padding":"0","margin":"0 20rpx 0 0"}'>
		    <text class="icon iconfont icon-zan10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#999"}'></text>
		    <text :style='{"color":"#999","lineHeight":"1.5","fontSize":"24rpx"}'>{{detail.thumbsupnum}}</text>
		  </view>
		  <view :style='{"padding":"0","margin":"0 20rpx 0 0"}'>
		    <text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#999"}'></text>
		    <text :style='{"color":"#999","lineHeight":"1.5","fontSize":"24rpx"}'>{{detail.storeupnum}}</text>
		  </view>
		  <view :style='{"padding":"0","margin":"0 20rpx 0 0"}'>
		    <text class="icon iconfont icon-chakan2" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#999"}'></text>
		    <text :style='{"color":"#999","lineHeight":"1.5","fontSize":"24rpx"}'>{{detail.clicknum}}</text>
		  </view>
		</view>
		
		<view :style='{"padding":"0 20rpx 24rpx 0","alignItems":"center","borderRadius":"0 0 16rpx 0","background":"#fff","display":"flex","width":"35%","justifyContent":"flex-end","order":"8"}'>
		  <view :style='{"border":"0px solid #eaeaea","padding":"0 20rpx 0 0","alignItems":"center","borderRadius":"16rpx","display":"flex","height":"64rpx"}' @click="likeClick">
		    <text class="icon iconfont" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"28rpx","color":"#666"}' :class="likeType?'icon-zan07':'icon-zan07'"></text>
		    <text :style='{"color":"#666","lineHeight":"1.5","fontSize":"28rpx"}'>{{likeType?'已':''}}赞</text>
		  </view>
		  <view :style='{"border":"0px solid #eaeaea","padding":"0 10rpx","alignItems":"center","borderRadius":"16rpx","display":"flex","height":"64rpx"}' @click="collectClick">
		    <text class="icon iconfont" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"28rpx","color":"#666"}' :class="collectType?'icon-shoucang10':'icon-shoucang10'"></text>
		    <text :style='{"color":"#666","lineHeight":"1.5","fontSize":"28rpx"}'>{{collectType?'已':''}}收藏</text>
		  </view>
		</view>
		
		<view class="content" :style='{"width":"100%","padding":"24rpx","margin":"0","fontSize":"28rpx","background":"#fff","height":"auto"}'>
			<rich-text :nodes="detail.content"></rich-text>
		</view>
		
		<div :style='{"padding":"0 24rpx 24rpx","alignItems":"center","borderRadius":"0 0 0 16rpx","background":"#fff","display":"flex","width":"65%","justifyContent":"space-between","height":"auto"}'>
		  <div @click="prepDetailClick" :style='{"border":"0px solid #eaeaea","padding":"0 10rpx","lineHeight":"64rpx","fontSize":"28rpx","color":"#666","borderRadius":"16rpx"}'>上一篇：prev</div>
		  <div @click="nextDetailClick" :style='{"border":"0px solid #eaeaea","padding":"0 10rpx","lineHeight":"64rpx","fontSize":"28rpx","color":"#666","borderRadius":"16rpx"}'>下一篇：next</div>
		</div>
		

		<!-- 热门 -->
		<view class="hot" :style='{"width":"100%","margin":"40rpx 0 0","background":"none","height":"auto","order":"11"}'>
		  <view :style='{"padding":"0 24rpx","color":"#223860","textAlign":"center","background":"url(http://codegen.caihongy.cn/20231208/dd4367eb2136483aa23e9dc12954f2df.png) no-repeat center top","width":"100%","fontSize":"32rpx","lineHeight":"100rpx","fontWeight":"600","height":"96rpx"}'>热门信息</view>
		  <view :style='{"padding":"24rpx 20rpx 24rpx","borderRadius":"0 0 0px 0px","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
		    <view v-for="(item,index) in hotList" :key="index" :style='{"width":"100%","padding":"20rpx","margin":"0 0 40rpx","background":"linear-gradient(30deg, rgba(246,249,255,1) 0%, rgba(239,244,255,1) 100%),#f1f6ff","clipPath":"polygon(2% 0, 100% 0, 98% 100%, 0% 100%)","height":"auto"}' @click="toDetail(item.id)">
			  <image :style='{"objectFit":"cover","borderRadius":"0px","display":"block","clipPath":"polygon(5% 0, 100% 0, 95% 100%, 0% 100%)","width":"32%","float":"left","height":"220rpx"}' mode="aspectFill" :src="baseUrl + item.picture"></image>
		      <view :style='{"padding":"0 8rpx","overflow":"hidden","whiteSpace":"nowrap","color":"#333","textAlign":"left","width":"64%","lineHeight":"60rpx","fontSize":"28rpx","textOverflow":"ellipsis","float":"right"}'>{{ item.title }}</view>
		      <view :style='{"padding":"0 8rpx","color":"#999","textAlign":"right","width":"64%","lineHeight":"48rpx","fontSize":"28rpx","float":"right"}'>{{ item.addtime }}</view>
		    </view>
		  </view>
		</view>
		<!-- 推荐 -->
		<view class="recommend" :style='{"width":"100%","margin":"40rpx 0 0","background":"none","height":"auto","order":"12"}'>
		  <view :style='{"padding":"0 24rpx","color":"#223860","textAlign":"center","background":"url(http://codegen.caihongy.cn/20231208/dd4367eb2136483aa23e9dc12954f2df.png) no-repeat center top","width":"100%","fontSize":"32rpx","lineHeight":"100rpx","fontWeight":"600","height":"96rpx"}'>推荐信息</view>
		  <view :style='{"padding":"12rpx 20rpx 24rpx","borderRadius":"0 0 0px 0px","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
		    <view v-for="(item,index) in recommendList" :key="index" :style='{"width":"100%","padding":"20rpx","margin":"0 0 40rpx","background":"linear-gradient(30deg, rgba(246,249,255,1) 0%, rgba(239,244,255,1) 100%),#f1f6ff","clipPath":"polygon(2% 0, 100% 0, 98% 100%, 0% 100%)","height":"auto"}' @click="toDetail(item.id)">
		      <image :style='{"objectFit":"cover","borderRadius":"0px","display":"block","clipPath":"polygon(5% 0, 100% 0, 95% 100%, 0% 100%)","width":"32%","float":"left","height":"220rpx"}' mode="aspectFill" :src="baseUrl + item.picture"></image>
			  <view :style='{"padding":"0 8rpx","overflow":"hidden","whiteSpace":"nowrap","color":"#333","textAlign":"left","width":"64%","lineHeight":"60rpx","fontSize":"28rpx","textOverflow":"ellipsis","float":"right"}'>{{ item.title }}</view>
		      <view :style='{"padding":"0 8rpx","color":"#999","textAlign":"right","width":"64%","lineHeight":"48rpx","fontSize":"28rpx","float":"right"}'>{{ item.addtime }}</view>
		    </view>
		  </view>
		</view>

	</view>
</template>
<script>
	export default {
		data() {
			return {
				detail: {},
				id: '',
				likeType: false,
				likeForm: {},
				collectType: false,
				collectForm: {},
				allList: [],
				currentIndex: 0,
				hotList: [],
				recommendList: [],
			}
		},
		async onLoad(options) {
			this.id = options.id;
			this.getInfo()
			
			this.getHotList()
			this.getRecommendList()
		},
		computed:{
			baseUrl() {
				return this.$base.url;
			},
			userid(){
				return uni.getStorageSync('appUserid')
			}
		},
		methods: {
			async getInfo(){
				let res = await this.$api.info('news', this.id)
				res.data.content = res.data.content.replace(/<img/g,'<img style="width: 100%;"');
				this.detail = res.data;
				uni.pageScrollTo({
					scrollTop: 0,
					duration: 100,
				})
				this.getLike()
				this.getCollect()
				res = await this.$api.list('news',{page:1,limit:100,sort:'addtime',order:'desc'})
				for(let x in res.data.list){
					if(res.data.list[x].id == this.id){
						this.currentIndex = Number(x)
						break
					}
				}
				this.allList = res.data.list
				
			},
			// 获取点赞状态
			async getLike() {
				let res = await this.$api.list('storeup', {
					page: 1,
					limit: 1,
					type: 21,
					userid: uni.getStorageSync('appUserid'),
					refid: this.id,
					tablename: 'news'
				})
				if (res.data.list.length) {
					this.likeType = true
					this.likeForm = res.data.list[0]
				} else {
					this.likeType = false
					this.likeForm = {}
				}
			},
			// 获取热门列表
			async getHotList(){
				let res = await this.$api.recommend('news',{page:1, limit: 4,sort:'addtime',order:'desc'})
				this.hotList = res.data.list;
			},
			// 获取推荐列表	
			async getRecommendList(){
				let res;
				if(uni.getStorageSync("appUserid")){
					res = await this.$api.recommend2('news',{page:1, limit: 4,sort:'addtime',order:'desc'})
				}else{
					res = await this.$api.recommend('news',{page:1, limit: 4,sort:'addtime',order:'desc'})
				}
				
				this.recommendList = res.data.list;
			},
			// 上一篇
			prepDetailClick(){
				if(this.currentIndex == 0){
					this.$message.error('已经是第一篇了')
					return false
				}
				this.currentIndex--
				this.id = this.allList[this.currentIndex].id
				this.getInfo()
			},
			// 下一篇
			nextDetailClick(){
				if(this.currentIndex == this.allList.length - 1){
					this.$message.error('已经是最后一篇了')
					return false
				}
				this.currentIndex++
				this.id = this.allList[this.currentIndex].id
				this.getInfo()
			},
			toDetail(id){
				this.id = id
				this.getInfo()
			},
			// 获取收藏状态
			async getCollect() {
				let res = await this.$api.list('storeup', {
					page: 1,
					limit: 1,
					type: 1,
					userid: uni.getStorageSync('appUserid'),
					refid: this.id,
					tablename: 'news'
				})
				if (res.data.list.length) {
					this.collectType = true
					this.collectForm = res.data.list[0]
				} else {
					this.collectType = false
					this.collectForm = {}
				}
			},
			// 点赞按钮
			async likeClick() {
				let that = this
				if (this.likeType) {
					uni.showModal({
						title: '提示',
						content: '是否取消点赞？',
						async success(res) {
							if (res.confirm) {
								await that.$api.del('storeup', JSON.stringify([that.likeForm.id]))
								that.$utils.msg('取消成功')
								that.detail.thumbsupnum--
								await that.$api.update('news', that.detail)
								that.getLike()
							}
						}
					})
				} else {
					await that.$api.add('storeup', {
						userid: uni.getStorageSync('appUserid'),
						refid: this.id,
						type: 21,
						name: this.detail.title,
						picture: this.detail.picture,
						tablename: 'news',
					})
					this.$utils.msg('点赞成功')
					that.detail.thumbsupnum++
					await that.$api.update('news', that.detail)
					this.getLike()
				}
			},
			// 收藏按钮
			async collectClick() {
				let that = this
				if (this.collectType) {
					uni.showModal({
						title: '提示',
						content: '是否取消收藏？',
						async success(res) {
							if (res.confirm) {
								await that.$api.del('storeup', JSON.stringify([that.collectForm.id]))
								that.$utils.msg('取消成功')
								that.detail.storeupnum--
								await that.$api.update('news', that.detail)
								that.getCollect()
							}
						}
					})
				} else {
					await that.$api.add('storeup', {
						userid: uni.getStorageSync('appUserid'),
						refid: this.id,
						type: 1,
						name: this.detail.title,
						picture: this.detail.picture,
						tablename: 'news',
					})
					this.$utils.msg('收藏成功')
					that.detail.storeupnum++
					await that.$api.update('news', that.detail)
					this.getCollect()
				}
			},
		}
	}
</script>

<style scoped lang="scss">
	page {
		background: #FFFFFF;
	}

	.title {
		text-align: center;
		font-size: 40upx;
		font-weight: bold;
		margin: 20upx;
	}

	.content {
		margin: 40upx;
		font-size: 30upx;
		line-height: 50upx;
		letter-spacing: 5upx;
	}
	.operateView {
		width: 100%;
		display: flex;
		align-items: center;
		justify-content: space-around;

		.like_box {
			width: 40%;
			display: flex;
			align-items: center;
			justify-content: center;
			font-size: 32rpx;

			.icon {
				font-size: 36rpx;
				padding: 0 6rpx;
			}
		}

		.likeActive {
			color: #f00;
		}
	}
</style>
