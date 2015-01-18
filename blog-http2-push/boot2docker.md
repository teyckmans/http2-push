Create a shared directory mapping in virtualbox to the root directory of the github project and name it 'blog-http2-push'.

mkdir blog-http2-push
sudo mount -t vboxsf blog-http2-push blog-http2-push
cd blog-http2-push/blog-http2-push/build/libs
docker rm blog-http2-push-one
docker rmi teyckmans/blog-http2-push
docker build --tag teyckmans/blog-http2-push .
docker run --name blog-http2-push-one -i -t -p 8443:8443 teyckmans/blog-http2-push