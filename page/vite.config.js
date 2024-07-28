import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue2';

export default defineConfig({
    plugins: [vue()],
    resolve: {
        alias: {
            '@': '/src',
        },
    },
    server: {
        port: 3000,
    },
});
