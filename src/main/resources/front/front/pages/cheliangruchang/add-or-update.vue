<template>
<view class="content">
	<view :style='{"minHeight":"100vh","width":"100%","padding":"24rpx","position":"relative","background":"#fff","height":"auto"}'>
		<form :style='{"width":"100%","padding":"24rpx","borderRadius":"0px","background":"#fff","display":"block","height":"auto"}' class="app-update-pv">
			<view :style='{"padding":"4rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 0px 0","background":"#f8f8f8","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">车位编号</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.cheweibianhao" v-model="ruleForm.cheweibianhao" placeholder="车位编号"></input>
			</view>
			<view :style='{"padding":"4rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 0px 0","background":"#f8f8f8","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">车位名称</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.cheweimingcheng" v-model="ruleForm.cheweimingcheng" placeholder="车位名称"></input>
			</view>
			<view :style='{"padding":"4rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 0px 0","background":"#f8f8f8","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">车位类型</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.cheweileixing" v-model="ruleForm.cheweileixing" placeholder="车位类型"></input>
			</view>
			<view :style='{"padding":"4rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 0px 0","background":"#f8f8f8","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="" @tap="cheweitupianTap">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">车位图片</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-if="ruleForm.cheweitupian" :src="baseUrl+ruleForm.cheweitupian.split(',')[0]" mode="aspectFill"></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
			</view>
			<view :style='{"padding":"4rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 0px 0","background":"#f8f8f8","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">车位位置</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.cheweiweizhi" v-model="ruleForm.cheweiweizhi" placeholder="车位位置"></input>
			</view>
			<view :style='{"padding":"4rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 0px 0","background":"#f8f8f8","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">收费标准</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.shoufeibiaozhun" v-model="ruleForm.shoufeibiaozhun" placeholder="收费标准"></input>
			</view>
			<view :style='{"padding":"4rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 0px 0","background":"#f8f8f8","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">停车价格</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.tingchejiage" v-model.number="ruleForm.tingchejiage" placeholder="停车价格"></input>
			</view>
			<view :style='{"padding":"4rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 0px 0","background":"#f8f8f8","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">账号</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.zhanghao" v-model="ruleForm.zhanghao" placeholder="账号"></input>
			</view>
			<view :style='{"padding":"4rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 0px 0","background":"#f8f8f8","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">姓名</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.xingming" v-model="ruleForm.xingming" placeholder="姓名"></input>
			</view>
			<view :style='{"padding":"4rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 0px 0","background":"#f8f8f8","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">手机</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.shouji" v-model="ruleForm.shouji" placeholder="手机"></input>
			</view>
			<view :style='{"padding":"4rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 0px 0","background":"#f8f8f8","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">车牌号码</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.chepaihaoma" v-model="ruleForm.chepaihaoma" placeholder="车牌号码"></input>
			</view>
			<view :style='{"padding":"4rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 0px 0","background":"#f8f8f8","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">入场时间</view>
				<input :disabled="ro.ruchangshijian" :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' v-model="ruleForm.ruchangshijian" placeholder="入场时间" @tap="toggleTab('ruchangshijian')"></input>
			</view>
			<view :style='{"padding":"4rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 0px 0","background":"#f8f8f8","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">车辆状态</view>
				<picker :disabled="ro.cheliangzhuangtai" :style='{"width":"100%","flex":"1","height":"auto"}' @change="cheliangzhuangtaiChange" :value="cheliangzhuangtaiIndex" :range="cheliangzhuangtaiOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#333"}' class="uni-input">{{ruleForm.cheliangzhuangtai?ruleForm.cheliangzhuangtai:"请选择车辆状态"}}</view>
				</picker>
			</view>
 

			
			<view :style='{"padding":"0","margin":"40rpx 0 0","flexWrap":"wrap","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}' class="btn" >
				<button :style='{"border":"0","padding":"0px","margin":"0 0 40rpx","color":"rgb(255, 255, 255)","borderRadius":"8rpx","background":"#223860","width":"100%","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}' @tap="onSubmitTap" class="bg-red">提交</button>
			</view>
		</form>

		<w-picker mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="ruchangshijianConfirm" ref="ruchangshijian" themeColor="#333333"></w-picker>
	</view>
</view>
</template>

<script>
	import wPicker from "@/components/w-picker/w-picker.vue";
    import xiaEditor from '@/components/xia-editor/xia-editor';
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
				cross:'',
				ruleForm: {
				cheweibianhao: '',
				cheweimingcheng: '',
				cheweileixing: '',
				cheweitupian: '',
				cheweiweizhi: '',
				shoufeibiaozhun: '',
				tingchejiage: '',
				zhanghao: '',
				xingming: '',
				shouji: '',
				chepaihaoma: '',
				ruchangshijian: '',
			        cheliangzhuangtai: '待出场',
				},
				cheliangzhuangtaiOptions: [],
				cheliangzhuangtaiIndex: 0,
				// 登录用户信息
				user: {},
                ro:{
                   cheweibianhao : false,
                   cheweimingcheng : false,
                   cheweileixing : false,
                   cheweitupian : false,
                   cheweiweizhi : false,
                   shoufeibiaozhun : false,
                   tingchejiage : false,
                   zhanghao : false,
                   xingming : false,
                   shouji : false,
                   chepaihaoma : false,
                   ruchangshijian : false,
                   cheliangzhuangtai : false,
                },
			}
		},
		components: {
			wPicker,
            xiaEditor,
            multipleSelect,
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},



		},
		async onLoad(options) {
            this.ruleForm.ruchangshijian = this.$utils.getCurDateTime();

			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			
			// ss读取


			// 自定义下拉框值
			this.cheliangzhuangtaiOptions = "已出场,待出场".split(',')

			// 如果有登录，获取登录后保存的userid
			this.ruleForm.userid = uni.getStorageSync("appUserid")
			if (options.refid) {
				// 如果上一级页面传递了refid，获取改refid数据信息
				this.ruleForm.refid = options.refid;
				this.ruleForm.nickname = uni.getStorageSync("nickname");
			}
			// 如果是更新操作
			if (options.id) {
				this.ruleForm.id = options.id;
				// 获取信息
				res = await this.$api.info(`cheliangruchang`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			// 跨表
			this.cross = options.cross;
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
				for (var o in obj){
					if(o=='cheweibianhao'){
					this.ruleForm.cheweibianhao = obj[o];
					this.ro.cheweibianhao = true;
					continue;
					}
					if(o=='cheweimingcheng'){
					this.ruleForm.cheweimingcheng = obj[o];
					this.ro.cheweimingcheng = true;
					continue;
					}
					if(o=='cheweileixing'){
					this.ruleForm.cheweileixing = obj[o];
					this.ro.cheweileixing = true;
					continue;
					}
					if(o=='cheweitupian'){
					this.ruleForm.cheweitupian = obj[o].split(",")[0];
					this.ro.cheweitupian = true;
					continue;
					}
					if(o=='cheweiweizhi'){
					this.ruleForm.cheweiweizhi = obj[o];
					this.ro.cheweiweizhi = true;
					continue;
					}
					if(o=='shoufeibiaozhun'){
					this.ruleForm.shoufeibiaozhun = obj[o];
					this.ro.shoufeibiaozhun = true;
					continue;
					}
					if(o=='tingchejiage'){
					this.ruleForm.tingchejiage = obj[o];
					this.ro.tingchejiage = true;
					continue;
					}
					if(o=='zhanghao'){
					this.ruleForm.zhanghao = obj[o];
					this.ro.zhanghao = true;
					continue;
					}
					if(o=='xingming'){
					this.ruleForm.xingming = obj[o];
					this.ro.xingming = true;
					continue;
					}
					if(o=='shouji'){
					this.ruleForm.shouji = obj[o];
					this.ro.shouji = true;
					continue;
					}
					if(o=='chepaihaoma'){
					this.ruleForm.chepaihaoma = obj[o];
					this.ro.chepaihaoma = true;
					continue;
					}
					if(o=='ruchangshijian'){
					this.ruleForm.ruchangshijian = obj[o];
					this.ro.ruchangshijian = true;
					continue;
					}
					if(o=='cheliangzhuangtai'){
					this.ruleForm.cheliangzhuangtai = obj[o];
					this.ro.cheliangzhuangtai = true;
					continue;
					}
				}
			}
			this.styleChange()
            this.$forceUpdate()
		},
		methods: {
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.app-update-pv . .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.addUpdateForm.input.content.backgroundColor
					// })
				})
			},

			// 多级联动参数


			// 日长控件选择日期时间
			ruchangshijianConfirm(val) {
				console.log(val)
				this.ruleForm.ruchangshijian = val.result;
				this.$forceUpdate();
			},

			// 下拉变化
			cheliangzhuangtaiChange(e) {
				this.cheliangzhuangtaiIndex = e.target.value
				this.ruleForm.cheliangzhuangtai = this.cheliangzhuangtaiOptions[this.cheliangzhuangtaiIndex]
			},

			cheweitupianTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.cheweitupian = 'upload/' + res.file;
					_this.$forceUpdate();
					_this.$nextTick(()=>{
						_this.styleChange()
					})
				});
			},

			getUUID () {
				return new Date().getTime();
			},
			async onSubmitTap() {
//跨表计算判断
				var obj;
				if(this.ruleForm.tingchejiage&&(!this.$validate.isNumber(this.ruleForm.tingchejiage))){
					this.$utils.msg(`停车价格应输入数字`);
					return
				}
				if(this.ruleForm.shouji&&(!this.$validate.isMobile(this.ruleForm.shouji))){
					this.$utils.msg(`手机应输入手机格式`);
					return
				}
				if((!this.ruleForm.cheliangzhuangtai)){
					this.$utils.msg(`车辆状态不能为空`);
					return
				}
				//更新跨表属性
				var crossuserid;
				var crossrefid;
				var crossoptnum;
				if(this.cross){
                    uni.setStorageSync('crossCleanType',true);
					var statusColumnName = uni.getStorageSync('statusColumnName');
					var statusColumnValue = uni.getStorageSync('statusColumnValue');
					if(statusColumnName!='') {
                        if(!obj) {
						    obj = uni.getStorageSync('crossObj');
                        }
						if(!statusColumnName.startsWith("[")) {
							for (var o in obj){
								if(o==statusColumnName){
									obj[o] = statusColumnValue;
								}

							}
							var table = uni.getStorageSync('crossTable');
							await this.$api.update(`${table}`, obj);
						} else {
						       crossuserid=Number(uni.getStorageSync('appUserid'));
						       crossrefid=obj['id'];
						       crossoptnum=uni.getStorageSync('statusColumnName');
						       crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
						}
					}
				}
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid=crossuserid;
					this.ruleForm.crossrefid=crossrefid;
					let params = {
						page: 1,
						limit:10,
						crossuserid:crossuserid,
						crossrefid:crossrefid,
					}
					let res = await this.$api.list(`cheliangruchang`, params);
					if (res.data.total >= crossoptnum) {
						this.$utils.msg(uni.getStorageSync('tips'));
                        uni.removeStorageSync('crossCleanType');
						return false;
					} else {
                //跨表计算
						if(this.ruleForm.id){
							await this.$api.update(`cheliangruchang`, this.ruleForm);
						}else{
							await this.$api.add(`cheliangruchang`, this.ruleForm);
						}
						this.$utils.msgBack('提交成功');
					}
				} else {
                //跨表计算
					if(this.ruleForm.id){
						await this.$api.update(`cheliangruchang`, this.ruleForm);
					}else{
						await this.$api.add(`cheliangruchang`, this.ruleForm);
					}
					this.$utils.msgBack('提交成功');
				}
			},
			optionsChange(e) {
				this.index = e.target.value
			},
			bindDateChange(e) {
				this.date = e.target.value
			},
			getDate(type) {
				const date = new Date();
				let year = date.getFullYear();
				let month = date.getMonth() + 1;
				let day = date.getDate();
				if (type === 'start') {
					year = year - 60;
				} else if (type === 'end') {
					year = year + 2;
				}
				month = month > 9 ? month : '0' + month;;
				day = day > 9 ? day : '0' + day;
				return `${year}-${month}-${day}`;
			},
			toggleTab(str) {
				if(this.ro[str]){
					return false
				}
				this.$refs[str].show();
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
