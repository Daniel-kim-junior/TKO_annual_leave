const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
  entry: './src/index.js',
  output: {
    filename: 'bundle.js',
    path: path.resolve(__dirname, 'dist')
  },

  module: {
    rules: [
      {
        test: /\.css$/,
        use: ['postcss-loader']
      }
    ]
  },
  devServer: {
    static: 'dist',
    port: 4000,
    static: './'
  },
  plugins: [
    new HtmlWebpackPlugin({
      template: '/src/index.html',
      file: '/dist/index.html'
    }),
  ]
};





