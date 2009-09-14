class CommentsController < ApplicationController
  def new
    @comment = Comment.new
  end
  
  def create
    @comment = Java::net.shenie.domain.Comment.new do |comment|
      comment.author_name = params[:comment][:author_name] 
      comment.site_url = params[:comment][:site_url]
      comment.content = params[:comment][:content]
      comment.created_at = comment.updated_at = Time.now
      comment.article = articles_repository.load(params[:comment][:article_id])
    end

    if comments_repository.save(@comment)
      flash[:notice] = "Successfully created comment."
      redirect_to article_url(@comment.article.get_id)
    else
      render :action => 'new'
    end
  end
  
  def edit
    @comment = Comment.find(params[:id])
  end
  
  def update
    @comment = Comment.find(params[:id])
    if @comment.update_attributes(params[:comment])
      flash[:notice] = "Successfully updated comment."
      redirect_to article_url(@comment.article_id)
    else
      render :action => 'edit'
    end
  end
  
  def destroy
    @comment = Comment.find(params[:id])
    @comment.destroy
    flash[:notice] = "Successfully destroyed comment."
    redirect_to article_url(@comment.article_id)
  end

end
