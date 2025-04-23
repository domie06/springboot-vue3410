const base = {
    get() {
        return {
            url : "http://localhost:8080/zhengwudating/",
            name: "zhengwudating",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/zhengwudating/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "政务大厅管理系统"
        } 
    }
}
export default base
