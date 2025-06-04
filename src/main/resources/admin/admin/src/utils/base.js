const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot530ktlhf/",
            name: "springboot530ktlhf",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot530ktlhf/front/h5/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于 Android 的停车管理系统的设计与实现"
        } 
    }
}
export default base
