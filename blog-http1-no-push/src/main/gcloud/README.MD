I've used the following command to boot up the http1 no push web module image (teyckmans/blog-http1-no-push)

gcloud compute instances create blog-http1-no-push-1 --image container-vm --metadata-from-file google-container-manifest=blog-http1-no-push.yaml --zone us-central1-a --machine-type f1-micro

D:\iAdvise\blog-http2-push\blog-http1-no-push\src\main\gcloud>gcloud compute instances create blog-http1-no-push-1 --ima
ge container-vm --metadata-from-file google-container-manifest=blog-http1-no-push.yaml --zone us-central1-a --machine-ty
pe f1-micro
Created [https://www.googleapis.com/compute/v1/projects/warm-now-816/zones/us-central1-a/instances/blog-http1-no-push-1]
.
NAME                 ZONE          MACHINE_TYPE INTERNAL_IP   EXTERNAL_IP     STATUS
blog-http1-no-push-1 us-central1-a f1-micro     10.240.131.60 130.211.155.163 RUNNING
