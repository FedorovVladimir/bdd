from django.shortcuts import render

from django.http import HttpResponseRedirect
from django.http import HttpResponseNotFound
# Create your views here.

def index (request):
    return render(request, 'index.html')

def makePattern (request):
    if request.method == "POST":
        name =  request.POST.get("name")
        return render(request, 'makePattern.html', {"name" : name})
    return render(request, 'index.html')
