class ArticlesController < ApplicationController

  def index
    @articles = articles_repository.loadAll
  end
  
  def show
    @article = articles_repository.load(params[:id])
    @comment = Java::net.shenie.domain.Comment.new
    @comment.article = @article
  end
  
  def new
    @article = Java::net.shenie.domain.Article.new
  end
  
  def create
    @article = Java::net.shenie.domain.Article.new do |article|
      article.name = params[:article][:name]
      article.content = params[:article][:content]
      article.author_name = params[:article][:author_name]
      article.created_at = article.updated_at = Time.now
    end
    
    if articles_repository.save(@article)
      flash[:notice] = "Successfully created article."
      redirect_to :action => 'show', :id => @article.get_id
    else
      render :action => 'new'
    end
  end
  
  def edit
    @article = articles_repository.load(params[:id])
  end
  
  def update
    @article = Article.find(params[:id])
    if @article.update_attributes(params[:article])
      flash[:notice] = "Successfully updated article."
      redirect_to @article
    else
      render :action => 'edit'
    end
  end
  
  def destroy
    @article = Article.find(params[:id])
    @article.destroy
    flash[:notice] = "Successfully destroyed article."
    redirect_to articles_url
  end

end
