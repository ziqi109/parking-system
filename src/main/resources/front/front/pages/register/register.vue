<template>
<view class="content">
	<view class="box" :style='{"minHeight":"100vh","width":"100%","padding":"480rpx 24rpx 24rpx","background":"url(http://codegen.caihongy.cn/20231210/72c7bbda27214bf8a74fc85be613606b.jpg) no-repeat center top / 100% auto,#fff","height":"auto"}'>
		<view :style='{"padding":"44rpx 44rpx 64rpx 24rpx","margin":"0 0 80rpx","borderRadius":"40rpx","background":"rgba(255,255,255,.6)","display":"block","width":"100%","position":"relative","height":"auto"}'>
			<image :style='{"width":"160rpx","margin":"0 auto 24rpx auto","borderRadius":"8rpx","display":"none","height":"160rpx"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" mode="aspectFill"></image>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","display":"flex","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"width":"180rpx","lineHeight":"76rpx","fontSize":"28rpx","color":"#666","textAlign":"right","fontWeight":"500"}' class="label">账号：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#f8f8f8","fontSize":"28rpx","height":"76rpx"}'  v-model="ruleForm.zhanghao"  type="text"  class="uni-input" name="" placeholder="账号" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","display":"flex","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"width":"180rpx","lineHeight":"76rpx","fontSize":"28rpx","color":"#666","textAlign":"right","fontWeight":"500"}' class="label">密码：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#f8f8f8","fontSize":"28rpx","height":"76rpx"}'  v-model="ruleForm.mima" type="password"  class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","display":"flex","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"width":"180rpx","lineHeight":"76rpx","fontSize":"28rpx","color":"#666","textAlign":"right","fontWeight":"500"}' class="label">确认密码：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#f8f8f8","fontSize":"28rpx","height":"76rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","display":"flex","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"width":"180rpx","lineHeight":"76rpx","fontSize":"28rpx","color":"#666","textAlign":"right","fontWeight":"500"}' class="label">姓名：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#f8f8f8","fontSize":"28rpx","height":"76rpx"}'  v-model="ruleForm.xingming"  type="text"  class="uni-input" name="" placeholder="姓名" />
			</view>
            <view :style='{"width":"100%","margin":"0 0 24rpx 0","display":"flex","height":"auto"}' v-if="tableName=='yonghu'" class="">
				<view :style='{"width":"180rpx","lineHeight":"76rpx","fontSize":"28rpx","color":"#666","textAlign":"right","fontWeight":"500"}' class="label">性别：</view>
				<picker :style='{"width":"calc(100% - 180rpx)","margin":"0 0 24rpx 0","display":"flex","height":"auto"}' v-if="tableName=='yonghu'"  @change="yonghuxingbieChange" :value="yonghuxingbieIndex" :range="yonghuxingbieOptions">
					<view>
						<view :style='{"lineHeight":"76rpx","fontSize":"28rpx","textDecoration":"underline","color":"#333"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
					</view>
				</picker>
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","display":"flex","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"width":"180rpx","lineHeight":"76rpx","fontSize":"28rpx","color":"#666","textAlign":"right","fontWeight":"500"}' class="label">手机：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#f8f8f8","fontSize":"28rpx","height":"76rpx"}'  v-model="ruleForm.shouji"  type="text"  class="uni-input" name="" placeholder="手机" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","display":"flex","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"width":"180rpx","lineHeight":"76rpx","fontSize":"28rpx","color":"#666","textAlign":"right","fontWeight":"500"}' class="label">车牌号码：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"#f8f8f8","fontSize":"28rpx","height":"76rpx"}'  v-model="ruleForm.chepaihaoma"  type="text"  class="uni-input" name="" placeholder="车牌号码" />
			</view>
            <view :style='{"width":"100%","margin":"0 0 24rpx 0","display":"flex","height":"auto"}' v-if="tableName=='yonghu'" @tap="yonghutouxiangTap" class="">
				<view :style='{"width":"180rpx","lineHeight":"76rpx","fontSize":"28rpx","color":"#666","textAlign":"right","fontWeight":"500"}' class="label">头像：</view>
				<image :style='{"width":"160rpx","borderRadius":"8rpx","objectFit":"cover","display":"block","height":"120rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
                <image :style='{"width":"160rpx","borderRadius":"8rpx","objectFit":"cover","display":"block","height":"120rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<button :style='{"border":"0","padding":"0px","margin":"0 0 24rpx 0","color":"rgb(255, 255, 255)","borderRadius":"8rpx","background":"#223860","width":"100%","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}' class="btn-submit" @tap="register" type="primary">注册</button>
			
			<view class="idea1" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea1</view>
			<view class="idea2" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea2</view>
			<view class="idea3" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea3</view>
		</view>
	</view>
</view>
</template>

<script>
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
                yonghuxingbieOptions: [],
                yonghuxingbieIndex: 0,
				ruleForm: {
                zhanghao: '',
                mima: '',
                xingming: '',
                xingbie: '',
                shouji: '',
                chepaihaoma: '',
                touxiang: '',
				},
				tableName:""
			}
		},
        components: {
            multipleSelect
        },
        computed: {
            baseUrl() {
                return this.$base.url;
            },
        },
		async onLoad() {
			let res = [];
			let table = uni.getStorageSync("loginTable");
            this.tableName = table;

                        // 自定义下拉框值
			if(this.tableName=='yonghu'){
                this.yonghuxingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.yonghuxingbieOptions[0]
			}
			
			this.styleChange()
		},
		methods: {

            // 下拉变化
            yonghuxingbieChange(e) {
                    this.yonghuxingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.yonghuxingbieOptions[this.yonghuxingbieIndex]
            },
            yonghutouxiangTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.touxiang = 'upload/' + res.file;
                    _this.$forceUpdate();
                });
            },
            toggleTab(str) {
                this.$refs[str].show();
            },

			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.uni-input .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.registerFrom.content.input.backgroundColor
					// })
				})
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 注册
			async register() {
				if((!this.ruleForm.zhanghao) && `yonghu` == this.tableName){
					this.$utils.msg(`账号不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `yonghu` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
                if(`yonghu` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
                    return
                }
				if(`yonghu` == this.tableName && this.ruleForm.shouji&&(!this.$validate.isMobile(this.ruleForm.shouji))){
					this.$utils.msg(`手机应输入手机格式`);
					return
				}
				if((!this.ruleForm.chepaihaoma) && `yonghu` == this.tableName){
					this.$utils.msg(`车牌号码不能为空`);
					return
				}
				await this.$api.register(`${this.tableName}`, this.ruleForm);
				this.$utils.msgBack('注册成功');;
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
