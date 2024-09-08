const state = {
    token: localStorage.getItem("token"),
    details: JSON.parse(localStorage.getItem("user"))
}

const getters = {}

const mutations = {

    saveToken(state, token) {
        state.token = token
        localStorage.setItem("token", token)
        console.log(localStorage.getItem("token"))
        console.log("执行saveToken")
    },

    saveLoginUser(state, user) {
        state.details = user
        localStorage.setItem("user", JSON.stringify(user))
        console.log("saveLoginUser")
    },

    userLogout(state) {
        state.details = null
        state.token = null
        localStorage.removeItem("token")
        localStorage.removeItem("user")
    }

}

const actions = {}

export default {
    namespaced: true,
    state,
    getters,
    mutations,
    actions
}