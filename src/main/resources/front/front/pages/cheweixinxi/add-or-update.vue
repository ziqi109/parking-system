<template>
<view class="content">
	<view :style='{"minHeight":"100vh","width":"100%","padding":"24rpx","position":"relative","background":"#fff","height":"auto"}'>
		<form :style='{"width":"100%","padding":"24rpx","borderRadius":"0px","background":"#fff","display":"block","height":"auto"}' class="app-update-pv">
			<view :style='{"padding":"4rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 0px 0","background":"#f8f8f8","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">停车场</view>
				<picker :disabled="ro.tingchechang" :style='{"width":"100%","flex":"1","height":"auto"}' @change="tingchechangChange" :value="tingchechangIndex" :range="tingchechangOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#333"}' class="uni-input">{{ruleForm.tingchechang?ruleForm.tingchechang:"请选择停车场"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"4rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 0px 0","background":"#f8f8f8","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">车位编号</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.cheweibianhao" v-model="ruleForm.cheweibianhao" placeholder="车位编号"></input>
			</view>
			<view :style='{"padding":"4rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 0px 0","background":"#f8f8f8","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">车位名称</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.cheweimingcheng" v-model="ruleForm.cheweimingcheng" placeholder="车位名称"></input>
			</view>
			<view :style='{"padding":"4rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 0px 0","background":"#f8f8f8","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">车位位置</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.cheweiweizhi" v-model="ruleForm.cheweiweizhi" placeholder="车位位置"></input>
			</view>
			<view :style='{"padding":"4rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 0px 0","background":"#f8f8f8","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">车位类型</view>
				<picker :disabled="ro.cheweileixing" :style='{"width":"100%","flex":"1","height":"auto"}' @change="cheweileixingChange" :value="cheweileixingIndex" :range="cheweileixingOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#333"}' class="uni-input">{{ruleForm.cheweileixing?ruleForm.cheweileixing:"请选择车位类型"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"4rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 0px 0","background":"#f8f8f8","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="" @tap="cheweitupianTap">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">车位图片</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-if="ruleForm.cheweitupian" :src="baseUrl+ruleForm.cheweitupian.split(',')[0]" mode="aspectFill"></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
			</view>
			<view :style='{"padding":"4rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 0px 0","background":"#f8f8f8","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">收费标准</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.shoufeibiaozhun" v-model="ruleForm.shoufeibiaozhun" placeholder="收费标准"></input>
			</view>
			<view :style='{"padding":"4rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 0px 0","background":"#f8f8f8","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">停车价格</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.tingchejiage" v-model.number="ruleForm.tingchejiage" placeholder="停车价格"></input>
			</view>
			<view :style='{"padding":"4rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 0px 0","background":"#f8f8f8","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">车位状态</view>
				<picker :disabled="ro.cheweizhuangtai" :style='{"width":"100%","flex":"1","height":"auto"}' @change="cheweizhuangtaiChange" :value="cheweizhuangtaiIndex" :range="cheweizhuangtaiOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#333"}' class="uni-input">{{ruleForm.cheweizhuangtai?ruleForm.cheweizhuangtai:"请选择车位状态"}}</view>
				</picker>
			</view>
 

			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","borderWidth":"0 0 0px 0","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"100%","padding":"0 20rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","fontWeight":"500"}' class="title">车位详情</view>
                <xia-editor ref="editor" :style='{"minHeight":"300rpx","border":"0px solid #efefef","width":"100%","padding":"20rpx","background":"#f8f8f8","height":"auto"}' v-model="ruleForm.cheweixiangqing" placeholder="车位详情" @editorChange="cheweixiangqingChange"></xia-editor>
			</view>
			
			<view :style='{"padding":"0","margin":"40rpx 0 0","flexWrap":"wrap","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}' class="btn" >
				<button :style='{"border":"0","padding":"0px","margin":"0 0 40rpx","color":"rgb(255, 255, 255)","borderRadius":"8rpx","background":"#223860","width":"100%","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}' @tap="onSubmitTap" class="bg-red">提交</button>
			</view>
		</form>

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
				tingchechang: '',
				cheweibianhao: '',
				cheweimingcheng: '',
				cheweiweizhi: '',
				cheweileixing: '',
				cheweitupian: '',
				shoufeibiaozhun: '',
				tingchejiage: '',
			        cheweizhuangtai: '空闲',
				cheweixiangqing: '',
				discussnum: '',
				storeupnum: '',
				},
				tingchechangOptions: [],
				tingchechangIndex: 0,
				cheweileixingOptions: [],
				cheweileixingIndex: 0,
				cheweizhuangtaiOptions: [],
				cheweizhuangtaiIndex: 0,
				// 登录用户信息
				user: {},
                ro:{
                   tingchechang : false,
                   cheweibianhao : false,
                   cheweimingcheng : false,
                   cheweiweizhi : false,
                   cheweileixing : false,
                   cheweitupian : false,
                   shoufeibiaozhun : false,
                   tingchejiage : false,
                   cheweizhuangtai : false,
                   cheweixiangqing : false,
                   discussnum : false,
                   storeupnum : false,
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
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			
			// ss读取


			// 下拉框
			res = await this.$api.option(`tingchechang`,`tingchechang`,{});
			this.tingchechangOptions = res.data;
            this.tingchechangOptions.unshift("请选择停车场");
			// 下拉框
			res = await this.$api.option(`cheweileixing`,`cheweileixing`,{});
			this.cheweileixingOptions = res.data;
            this.cheweileixingOptions.unshift("请选择车位类型");
			// 自定义下拉框值
			this.cheweizhuangtaiOptions = "占用,空闲".split(',')

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
				res = await this.$api.info(`cheweixinxi`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			// 跨表
			this.cross = options.cross;
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
				for (var o in obj){
					if(o=='tingchechang'){
					this.ruleForm.tingchechang = obj[o];
					this.ro.tingchechang = true;
					continue;
					}
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
					if(o=='cheweiweizhi'){
					this.ruleForm.cheweiweizhi = obj[o];
					this.ro.cheweiweizhi = true;
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
					if(o=='cheweizhuangtai'){
					this.ruleForm.cheweizhuangtai = obj[o];
					this.ro.cheweizhuangtai = true;
					continue;
					}
					if(o=='cheweixiangqing'){
					this.ruleForm.cheweixiangqing = obj[o];
					this.ro.cheweixiangqing = true;
					continue;
					}
					if(o=='discussnum'){
					this.ruleForm.discussnum = obj[o];
					this.ro.discussnum = true;
					continue;
					}
					if(o=='storeupnum'){
					this.ruleForm.storeupnum = obj[o];
					this.ro.storeupnum = true;
					continue;
					}
				}
			}
			this.styleChange()
            this.$forceUpdate()
		},
		methods: {
            cheweixiangqingChange(e) {
                this.ruleForm.cheweixiangqing = e
            },
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.app-update-pv . .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.addUpdateForm.input.content.backgroundColor
					// })
				})
			},

			// 多级联动参数



			// 下拉变化
			tingchechangChange(e) {
				this.tingchechangIndex = e.target.value
				this.ruleForm.tingchechang = this.tingchechangOptions[this.tingchechangIndex]
			},
			// 下拉变化
			cheweileixingChange(e) {
				this.cheweileixingIndex = e.target.value
				this.ruleForm.cheweileixing = this.cheweileixingOptions[this.cheweileixingIndex]
			},
			// 下拉变化
			cheweizhuangtaiChange(e) {
				this.cheweizhuangtaiIndex = e.target.value
				this.ruleForm.cheweizhuangtai = this.cheweizhuangtaiOptions[this.cheweizhuangtaiIndex]
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
				if((!this.ruleForm.cheweibianhao)){
					this.$utils.msg(`车位编号不能为空`);
					return
				}
				if((!this.ruleForm.tingchejiage)){
					this.$utils.msg(`停车价格不能为空`);
					return
				}
				if(this.ruleForm.tingchejiage&&(!this.$validate.isNumber(this.ruleForm.tingchejiage))){
					this.$utils.msg(`停车价格应输入数字`);
					return
				}
				if(this.ruleForm.discussnum&&(!this.$validate.isIntNumer(this.ruleForm.discussnum))){
					this.$utils.msg(`评论数应输入整数`);
					return
				}
				if(this.ruleForm.storeupnum&&(!this.$validate.isIntNumer(this.ruleForm.storeupnum))){
					this.$utils.msg(`收藏数应输入整数`);
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
					let res = await this.$api.list(`cheweixinxi`, params);
					if (res.data.total >= crossoptnum) {
						this.$utils.msg(uni.getStorageSync('tips'));
                        uni.removeStorageSync('crossCleanType');
						return false;
					} else {
                //跨表计算
						if(this.ruleForm.id){
							await this.$api.update(`cheweixinxi`, this.ruleForm);
						}else{
							await this.$api.add(`cheweixinxi`, this.ruleForm);
						}
						this.$utils.msgBack('提交成功');
					}
				} else {
                //跨表计算
					if(this.ruleForm.id){
						await this.$api.update(`cheweixinxi`, this.ruleForm);
					}else{
						await this.$api.add(`cheweixinxi`, this.ruleForm);
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
