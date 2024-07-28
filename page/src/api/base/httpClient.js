// src/api/httpClient.js
import axios from 'axios';
import store from '@/store';

const httpClient = (version = 'v1', useToken = true) => {
    const instance = axios.create({
        baseURL: `${import.meta.env.VITE_API_BASE_URL}/${version}`,
        headers: {
            'Content-Type': 'application/json',
        },
    });

    // 请求拦截器
    instance.interceptors.request.use(
        (config) => {
            if (useToken && store.state.token) {
                config.headers['Authorization'] = `Bearer ${store.state.token}`;
            }
            return config;
        },
        (error) => {
            return Promise.reject(error);
        }
    );

    // 响应拦截器
    instance.interceptors.response.use(
        (response) => response,
        (error) => {
            return Promise.reject(error);
        }
    );

    return instance;
};

const defaultClient = httpClient(); // 创建一个带默认值的客户端实例

export { httpClient, defaultClient };
