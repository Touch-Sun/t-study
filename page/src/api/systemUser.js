import { defaultClient, httpClient } from '@/api/base/httpClient';

const path = '/system/user';

export default {
    /**
     * 用户登录
     * @param {Object} credentials - 用户凭证 { username: String, password: String }
     * @returns {Promise} - Axios response promise
     */
    login(credentials) {
        return httpClient('v1', false).post(path + '/login', credentials);
    },

    /**
     * 用户注册
     * @param {Object} userData - 用户注册数据 { username: String, email: String, password: String }
     * @returns {Promise} - Axios response promise
     */
    register(userData) {
        return httpClient('v1', false).post(path + '/register', userData);
    },

    /**
     * 获取当前用户信息
     * @returns {Promise} - Axios response promise
     */
    getCurrentUser() {
        return defaultClient.get(path + '/getCurrentUser');
    },

    /**
     * 用户登出
     * @returns {Promise} - Axios response promise
     */
    logout() {
        return defaultClient.post(path + '/logout');
    },
};
